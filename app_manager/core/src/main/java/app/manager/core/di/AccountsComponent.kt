package app.manager.core.di

import android.content.Context
import app.manager.core.accounts.AccountTools
import app.manager.core.di.module.AccountToolsModule
import app.manager.core.di.module.ContextModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ContextModule::class, AccountToolsModule::class])
interface AccountsComponent {

    val context: Context
    val accountTool: AccountTools
}