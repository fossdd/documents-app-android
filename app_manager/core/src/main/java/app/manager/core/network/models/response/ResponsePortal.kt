package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.user.Portal
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponsePortal : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: Portal? = null
}