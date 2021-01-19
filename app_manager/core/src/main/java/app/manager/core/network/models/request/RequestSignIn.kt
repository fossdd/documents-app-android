package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class RequestSignIn {
    @SerializedName("userName")
    @Expose
    var userName: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("provider")
    @Expose
    var provider: String? = null

    @SerializedName("accessToken")
    @Expose
    var accessToken: String? = null
}