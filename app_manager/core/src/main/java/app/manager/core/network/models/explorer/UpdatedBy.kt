package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class UpdatedBy {
    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("displayName")
    @Expose
    var displayName = ""

    @SerializedName("avatarSmall")
    @Expose
    var avatarSmall = ""

    @SerializedName("profileUrl")
    @Expose
    var profileUrl = ""

}