package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestExternal {
    @SerializedName("share")
    @Expose
    var share: String? = null
}