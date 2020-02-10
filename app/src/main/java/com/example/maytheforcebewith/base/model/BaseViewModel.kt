package com.example.maytheforcebewith.base.model

import androidx.lifecycle.ViewModel
import com.example.maytheforcebewith.injection.components.DaggerViewModelInjector
import com.example.maytheforcebewith.injection.components.ViewModelInjector
import com.example.maytheforcebewith.injection.module.ApiModule
import com.example.maytheforcebewith.ui.details.DetailsViewModel
import com.example.maytheforcebewith.ui.main.MainViewModel

open class BaseViewModel : ViewModel() {
    private val injectorApi: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(ApiModule)
        .build()

    init {
        inject()
    }

    /**
     * Dagger inject
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injectorApi.inject(this)
            is DetailsViewModel -> injectorApi.inject(this)
        }
    }
}