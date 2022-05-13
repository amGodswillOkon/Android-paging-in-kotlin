package com.amgodswillokon.justcontact.contactviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.amgodswillokon.justcontact.contactmodel.ContactData
import com.amgodswillokon.justcontact.contactmodel.NumbersFactory

class ViewModelClass : ViewModel() {
//configuration for PagedList Adapter
    val sizeOfPage =20
    val configuration =  PagedList.Config.Builder()
        .setPageSize(sizeOfPage)
        .setInitialLoadSizeHint(20)
        .setPrefetchDistance(5)
        .setEnablePlaceholders(false)
        .build()

//connection ViewModel with Model
var numberDataSource =  NumbersFactory()
    var viewModelContact: LiveData<PagedList<ContactData>> =
        LivePagedListBuilder(numberDataSource,configuration)
        .build()
}
