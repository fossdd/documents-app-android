package app.manager.core.di.module

import android.content.Context
import app.manager.core.accounts.AccountTools
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AccountToolsModule() {

    @Singleton
    @Provides
    fun provideAccountTool(context: Context) = AccountTools(context)

}