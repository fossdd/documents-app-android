package app.manager.core.network.models.register

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tenant {
    @SerializedName("created")
    @Expose
    var created = ""

    @SerializedName("domain")
    @Expose
    var domain = ""

    @SerializedName("language")
    @Expose
    var language = ""

    @SerializedName("ownerId")
    @Expose
    var ownerId = ""

    @SerializedName("portalName")
    @Expose
    var portalName = ""

    @SerializedName("status")
    @Expose
    var status = ""

    @SerializedName("tenantId")
    @Expose
    var tenantId = 0

    @SerializedName("timeZoneName")
    @Expose
    var timeZoneName = ""
}