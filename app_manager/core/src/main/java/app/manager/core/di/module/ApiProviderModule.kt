package app.manager.core.di.module

import app.manager.core.network.Api
import app.manager.core.network.ApiProvider
import app.manager.core.network.implementations.ApiProviderImpl
import dagger.Module
import dagger.Provides

@Module
class ApiProviderModule(val token: String?) {

    @Provides
    fun getApiProvider(api: Api) : ApiProvider {
        return ApiProviderImpl(api, token)
    }

}