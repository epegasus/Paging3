package dev.pegasus.paging3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dev.pegasus.paging3.repository.Repository

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */
class DataViewModel(repository: Repository) : ViewModel() {

    val list = repository.fetchQuotes().cachedIn(viewModelScope)

}