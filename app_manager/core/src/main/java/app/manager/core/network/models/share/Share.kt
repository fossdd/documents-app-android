package app.manager.core.network.models.share

import app.manager.core.network.Api
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Share : Serializable {
    @SerializedName("access")
    @Expose
    var access: Int = Api.ShareCode.NONE

    @SerializedName("sharedTo")
    @Expose
    var sharedTo = SharedTo()

    @SerializedName("isLocked")
    @Expose
    var isLocked = false

    @SerializedName("isOwner")
    @Expose
    var isOwner = false

    var newAccess: Int = Api.ShareCode.NONE

}