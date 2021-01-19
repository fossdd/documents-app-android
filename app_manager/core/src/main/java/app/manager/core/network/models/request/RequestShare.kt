package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestShare {
    @SerializedName("share")
    @Expose
    var share: List<RequestShareItem>? = null

    @SerializedName("notify")
    @Expose
    var isNotify = false

    @SerializedName("sharingMessage")
    @Expose
    var sharingMessage: String? = null
}