package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestValidatePortal {
    @SerializedName("portalName")
    @Expose
    var portalName: String? = null
}