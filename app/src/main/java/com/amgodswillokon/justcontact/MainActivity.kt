package com.amgodswillokon.justcontact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amgodswillokon.justcontact.contactutils.ContactSavedNumbers
import com.amgodswillokon.justcontact.contactview.ContactViewAdapter
import com.amgodswillokon.justcontact.contactviewmodel.ViewModelClass

/**
 * Simple app "Just Contact"
 * showing how ot make use of a
 * paging library using MVVM architecture
 * Created by Godswill Okon 13/05/2022**/

class MainActivity : AppCompatActivity() {
    val connectViewModel = ViewModelClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ContactSavedNumbers.readFromContact(this)

  //add divider to recycler view
        val recyclerViewVerticalLine = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

//setting up recycler view
        val recyclerViewSetUp = findViewById<RecyclerView>(R.id.contact_rv)
        val contactAdapter = ContactViewAdapter()

        recyclerViewSetUp.layoutManager = LinearLayoutManager(this)
        recyclerViewSetUp.adapter = contactAdapter

        recyclerViewSetUp.addItemDecoration(recyclerViewVerticalLine)

// connecting 'Viewmodel' to view
        connectViewModel.viewModelContact.observe(this, {contactBook ->
            contactAdapter.submitList(contactBook)
        })
    }
}


