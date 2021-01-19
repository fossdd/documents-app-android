package app.manager.core.network.models.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Settings {
    @SerializedName("communityServer")
    @Expose
    var communityServer: String = ""

    @SerializedName("documentServer")
    @Expose
    var documentServer: String = ""

    @SerializedName("mailServer")
    @Expose
    var mailServer: String = ""
}