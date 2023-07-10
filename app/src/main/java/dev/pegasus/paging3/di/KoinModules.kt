package dev.pegasus.paging3.di

import dev.pegasus.paging3.repository.Repository
import dev.pegasus.paging3.viewModels.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class KoinModules {

    private val viewModelModules = module {
        single { Repository() }
        viewModel { DataViewModel(get()) }
    }

    val list = listOf(viewModelModules)
}