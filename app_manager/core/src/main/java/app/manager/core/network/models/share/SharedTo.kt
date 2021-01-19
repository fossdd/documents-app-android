package app.manager.core.network.models.share

import app.manager.core.network.models.user.Group
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import lib.toolkit.base.managers.utils.StringUtils.getHtmlString
import java.io.Serializable
import java.util.*

class SharedTo : Serializable {
    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("userName")
    @Expose
    var userName: String? = null

    @SerializedName("isVisitor")
    @Expose
    var isVisitor = false

    @SerializedName("firstName")
    @Expose
    var firstName = ""

    @SerializedName("lastName")
    @Expose
    var lastName = ""

    @SerializedName("email")
    @Expose
    var email = ""

    @SerializedName("status")
    @Expose
    var status = 0

    @SerializedName("activationStatus")
    @Expose
    var activationStatus = 0

    @SerializedName("terminated")
    @Expose
    private var terminated = ""

    @SerializedName("department")
    @Expose
    var department = ""

    @SerializedName("workFrom")
    @Expose
    var workFrom = ""

    @SerializedName("displayName")
    @Expose
    var displayName = ""

    @SerializedName("mobilePhone")
    @Expose
    var mobilePhone = ""

    @SerializedName("groups")
    @Expose
    var groups: List<Group> = ArrayList<Group>()

    @SerializedName("avatarMedium")
    @Expose
    var avatarMedium = ""

    @SerializedName("avatar")
    @Expose
    var avatar = ""

    @SerializedName("isOnline")
    @Expose
    var isOnline = false

    @SerializedName("isAdmin")
    @Expose
    var isAdmin = false

    @SerializedName("isLDAP")
    @Expose
    var isLDAP = false

    @SerializedName("listAdminModules")
    @Expose
    var listAdminModules: List<String> = ArrayList()

    @SerializedName("isOwner")
    @Expose
    var isOwner = false

    @SerializedName("isSSO")
    @Expose
    var isSSO = false

    @SerializedName("avatarSmall")
    @Expose
    var avatarSmall = ""

    @SerializedName("profileUrl")
    @Expose
    var profileUrl = ""

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("manager")
    @Expose
    private var manager = ""

    @SerializedName("shareLink")
    @Expose
    var shareLink: String? = null
    fun getTerminated(): Any {
        return terminated
    }

    fun setTerminated(terminated: String) {
        this.terminated = terminated
    }

    val displayNameHtml: String
        get() = getHtmlString(displayName)

    fun getManager(): Any {
        return manager
    }

    fun setManager(manager: String) {
        this.manager = manager
    }
}