package com.amgodswillokon.justcontact.contactutils

import android.content.Context
import android.util.Log
import com.amgodswillokon.justcontact.contactmodel.ContactData
import com.google.gson.Gson

class ContactSavedNumbers {

    //Class to deserialize Json to object
companion object {
    lateinit var numbers: ArrayList<ContactData>

    fun readFromContact(context: Context){
        val contact = context.assets.open("just_contact.json")
            .bufferedReader()
            .use {
                it.readText()
            }
        numbers =  ArrayList(Gson()
            .fromJson(contact, Array<ContactData>::class.java)
            .toList())
    }

    fun returnContact(): List<ContactData>{
        return numbers
    }

  }
}
