package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.explorer.Explorer
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseExplorer : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: Explorer? = null
}