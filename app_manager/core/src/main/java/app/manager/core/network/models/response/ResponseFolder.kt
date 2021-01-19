package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.explorer.CloudFolder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseFolder : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: CloudFolder? = null
}