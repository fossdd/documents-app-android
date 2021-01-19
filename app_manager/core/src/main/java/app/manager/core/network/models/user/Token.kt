package app.manager.core.network.models.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Token {
    @SerializedName("token")
    @Expose
    var token = ""

    @SerializedName("expires")
    @Expose
    var expires = ""

    @SerializedName("sms")
    @Expose
    var sms = false

    @SerializedName("phoneNoise")
    @Expose
    var phoneNoise = ""

    @SerializedName("tfa")
    @Expose
    var tfa = false

    @SerializedName("tfaKey")
    @Expose
    var tfaKey = ""
}