package app.manager.core.accounts

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AuthenticatorService : Service() {

    var mAuthenticatorAccounts: AuthenticatorAccounts? = null

    override fun onBind(intent: Intent?): IBinder? {
        mAuthenticatorAccounts = AuthenticatorAccounts(applicationContext)
        return mAuthenticatorAccounts?.iBinder
    }

}