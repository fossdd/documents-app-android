package app.manager.core.network.models.response

import app.manager.core.network.models.register.Tenant
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseRegisterPortal {
    @SerializedName("reference")
    @Expose
    var reference: String? = null

    @SerializedName("tenant")
    @Expose
    var tenant: Tenant? = null
}