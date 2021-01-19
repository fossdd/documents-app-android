package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.base.Settings
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseSettings : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: Settings? = null
}