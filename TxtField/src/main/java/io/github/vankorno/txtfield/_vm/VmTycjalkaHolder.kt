package io.github.vankorno.txtfield._vm

import android.app.Application
import androidx.activity.ComponentActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object VmTycjalkaHolder {
    private lateinit var provider: ViewModelProvider
    
    val vmTycjalka by lazy { get<VmTycjalka>() }
    
    private inline fun <reified T : ViewModel> get(): T = provider[T::class.java]
    
    
    fun init(                                                           activity: ComponentActivity,
                                                                     application: Application,
    ) {
        provider = ViewModelProvider(
            owner = activity,
            factory = SavedStateViewModelFactory(application, activity)
        )
    }
}