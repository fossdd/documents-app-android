package app.manager.core.di

import app.manager.core.di.module.ApiProviderModule
import app.manager.core.di.module.RetrofitModule
import app.manager.core.network.ApiProvider
import dagger.Component

@Component(modules = [RetrofitModule::class, ApiProviderModule::class])
interface RetrofitComponent {

    val apiProvider: ApiProvider

}