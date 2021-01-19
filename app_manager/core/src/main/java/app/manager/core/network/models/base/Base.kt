package app.manager.core.network.models.base

import app.manager.core.network.models.base.Error
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

open class Base {

    companion object {
        const val KEY_COUNT = "count"
        const val KEY_STATUS = "status"
        const val KEY_STATUS_CODE = "statusCode"
        const val KEY_ERROR = "error"
        const val KEY_RESPONSE = "response"
    }



    @SerializedName(KEY_COUNT)
    @Expose
    var count = 0

    @SerializedName(KEY_STATUS)
    @Expose
    var status = ""

    @SerializedName(KEY_STATUS_CODE)
    @Expose
    var statusCode = ""

    @SerializedName(KEY_ERROR)
    @Expose
    var error = Error()


    /*
    * Comparators
    * */
    abstract class AbstractSort<Type>(isSortAsc: Boolean) :
        Comparator<Type> {
        protected var mSortOrder = SORT_ORDER_ASC

        companion object {
            const val SORT_ORDER_ASC = 1
            const val SORT_ORDER_DESC = -1
        }

        init {
            mSortOrder = if (isSortAsc) SORT_ORDER_ASC else SORT_ORDER_DESC
        }
    }
}