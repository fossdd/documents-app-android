package app.manager.core.network.models.response


import app.manager.core.network.models.base.Base
import app.manager.core.network.models.user.Group
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseGroups : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: List<Group>? = null
}