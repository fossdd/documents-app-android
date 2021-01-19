package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.user.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseUsers : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: List<User>? = null
}