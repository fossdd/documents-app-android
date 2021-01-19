package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.user.Token
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseSignIn : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: Token? = null
}