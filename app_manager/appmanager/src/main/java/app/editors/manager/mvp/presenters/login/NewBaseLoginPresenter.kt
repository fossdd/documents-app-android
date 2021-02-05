package app.editors.manager.mvp.presenters.login

import android.content.Context
import app.editors.manager.app.App
import app.editors.manager.managers.tools.AccountManagerTool
import app.editors.manager.managers.tools.AccountSqlTool
import app.editors.manager.managers.tools.PreferenceTool
import app.editors.manager.managers.tools.RetrofitTool
import app.editors.manager.mvp.models.states.OperationsState
import app.manager.core.accounts.AccountTools
import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject

abstract class NewBaseLoginPresenter<T : MvpView> : MvpPresenter<T>() {

    protected val GOOGLE_PERMISSION = "GOOGLE_PERMISSION"
    protected val KEY_NULL_VALUE = "null"


    @Inject
    protected var mContext: Context? = null

    @Inject
    protected var mPreferenceTool: PreferenceTool? = null

    @Inject
    protected var mRetrofitTool: RetrofitTool? = null

    @Inject
    protected var mAccountManagerTool: AccountManagerTool? = null

    @Inject
    protected var mAccountSqlTool: AccountSqlTool? = null

    @Inject
    protected var mOperationsState: OperationsState? = null

    val mAccountTools: AccountTools = App.getApp().accountComponent.accountTool

    fun getApi() {

    }

}