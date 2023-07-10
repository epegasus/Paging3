package dev.pegasus.paging3.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import dev.pegasus.paging3.paging.DataPagingSource

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class Repository {

    fun fetchQuotes() = Pager(
        config = PagingConfig(20, maxSize = 100),
        pagingSourceFactory = { DataPagingSource() }
    ).liveData

}