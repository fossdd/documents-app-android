package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.share.Share
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseShare : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: List<Share>? = null
}