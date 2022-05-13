package com.amgodswillokon.justcontact.contactview

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.amgodswillokon.justcontact.contactmodel.ContactData


//Using PagedListAdapter to page data
class ContactViewAdapter : PagedListAdapter<ContactData, ContactViewHolder>(DIFFUTIL_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        return ContactViewHolder.createContact(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contactInfo = getItem(position)
        if (contactInfo != null) {
            holder.bindContact(contactInfo)
        }

    }

    companion object {
        private val DIFFUTIL_CALLBACK = object : DiffUtil.ItemCallback<ContactData>() {
            override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}

