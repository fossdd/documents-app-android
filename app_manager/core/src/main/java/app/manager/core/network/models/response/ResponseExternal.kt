package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseExternal : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: String? = null
}