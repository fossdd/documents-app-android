package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseValidatePortal : Base() {
    @SerializedName(KEY_MESSAGE)
    @Expose
    var message: String? = null

    @SerializedName(KEY_ERROR)
    @Expose
    var errors: String? = null

    @SerializedName(KEY_VARIANTS)
    @Expose
    var variants: String? = null

    companion object {
        const val KEY_MESSAGE = "message"
        const val KEY_ERROR = "errors"
        const val KEY_VARIANTS = "variants"
    }
}