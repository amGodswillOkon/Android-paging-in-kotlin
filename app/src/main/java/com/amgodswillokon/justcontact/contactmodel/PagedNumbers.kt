package com.amgodswillokon.justcontact.contactmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.amgodswillokon.justcontact.contactutils.ContactSavedNumbers
import org.apache.http.params.CoreConnectionPNames

//PagedKedDataSource API is used for paging
class PagedNumbers : PageKeyedDataSource<Int, ContactData>() {
    private val sourceNumbers = ContactSavedNumbers.returnContact()

   override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ContactData>
    ) {
      val loadInitialNumber = sourceNumbers.filter { initialLoadNumbers ->
          initialLoadNumbers.page == 1 }
        callback.onResult(loadInitialNumber, null, 2)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ContactData>) {
        val loadBeforeNumbers = sourceNumbers.filter { beforeLoadNumbers ->
            beforeLoadNumbers.page == params.key }
        callback.onResult(loadBeforeNumbers, params.key -1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ContactData>) {
        val loadAfterNumbers = sourceNumbers.filter { afterLoadNumbebrs ->
            afterLoadNumbebrs.page == params.key }
            callback.onResult(loadAfterNumbers, params.key +1)
    }
}

class  NumbersFactory : DataSource.Factory<Int, ContactData>(){
    var sourceData = MutableLiveData<PagedNumbers>()
    lateinit var numberDataSource: PagedNumbers

    override fun create(): DataSource<Int, ContactData> {
        numberDataSource = PagedNumbers()
        sourceData.postValue(numberDataSource)
        return numberDataSource
    }
}

