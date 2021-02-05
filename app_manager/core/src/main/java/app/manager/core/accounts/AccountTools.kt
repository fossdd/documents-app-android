package app.manager.core.accounts

import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import android.os.Bundle
import androidx.annotation.Nullable
import app.manager.core.R

class AccountTools(val context: Context) {

    companion object {
        const val ACCOUNT_PORTAL_URL = "portal"
        const val ACCOUNT_TOKEN = "auth_token"
        const val KEY_IS_CURRENT = "is_current"
        const val KEY_IS_SSL_ON = "is_ssl_on"
    }


    private val mType by lazy { context.getString(R.string.account_type) }
    private val mAccountManager by lazy { AccountManager.get(context) }

    fun getAccounts(): Array<Account> =
        mAccountManager.getAccountsByType(mType)

    @Nullable
    fun getCurrentAccount(): Account? {
        mAccountManager.getAccountsByType(mType).forEach { account ->
            val isCurrent = mAccountManager.getUserData(account, KEY_IS_CURRENT)?.toBoolean()
            if (isCurrent == true) {
                return account
            }
        }
        return null
    }

    @Nullable
    fun getAccountByName(name: String): Account? {
        mAccountManager.accounts.forEach {
            if (it.name == name) {
                return it
            }
        }
        return null
    }

    fun addAccount(account: Account, password: String, data: Bundle) =
        mAccountManager.addAccountExplicitly(account, password, data)

    fun getToken(account: Account): String =
        mAccountManager.peekAuthToken(account, mType)


}