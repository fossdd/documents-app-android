package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestRegister {
    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null

    @SerializedName("portalName")
    @Expose
    var portalName: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("timeZoneName")
    @Expose
    var timeZoneName: String? = null

    @SerializedName("appKey")
    @Expose
    var appKey: String? = null
}