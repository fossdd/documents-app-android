package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestTitle {
    @SerializedName("title")
    @Expose
    var title: String? = null
}