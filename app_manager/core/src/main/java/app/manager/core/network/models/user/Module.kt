package app.manager.core.network.models.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Module {
    @SerializedName("webItemId")
    @Expose
    var webItemId: String? = null

    @SerializedName("users")
    @Expose
    var users: List<User>? = null

    @SerializedName("groups")
    @Expose
    var groups: List<Group>? = null

    @SerializedName("enabled")
    @Expose
    var isEnable = false

    @SerializedName("isSubItem")
    @Expose
    var isSubItem = false
}