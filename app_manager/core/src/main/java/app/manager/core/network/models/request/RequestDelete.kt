package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestDelete {
    @SerializedName("deleteAfter")
    @Expose
    var deleteAfter = false
}