package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.explorer.CloudFile
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseCreateFile : Base() {
    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: CloudFile? = null
}