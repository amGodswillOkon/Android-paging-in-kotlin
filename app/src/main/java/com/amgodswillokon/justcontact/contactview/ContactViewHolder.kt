package com.amgodswillokon.justcontact.contactview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amgodswillokon.justcontact.R
import com.amgodswillokon.justcontact.contactmodel.ContactData


//Binding data to RecyclerView
class ContactViewHolder(view: View) :  RecyclerView.ViewHolder(view){
    val contactNameSet = view.findViewById<TextView>(R.id.name_tv)
    val contactPhoneSet = view.findViewById<TextView>(R.id.phone_number_tv)

    fun bindContact(contact : ContactData){
        var contactName = contact.name
        var contactPhone = contact.phone

        contactNameSet.text = contactName
        contactPhoneSet.text = contactPhone
    }

    companion object{
        fun createContact(parent : ViewGroup) : ContactViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_rv_design, parent, false)
            return  ContactViewHolder(view)
        }
    }

}