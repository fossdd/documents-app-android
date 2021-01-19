package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestNumber : RequestSignIn() {
    @SerializedName("mobilePhone")
    @Expose
    var mobilePhone: String? = null
}