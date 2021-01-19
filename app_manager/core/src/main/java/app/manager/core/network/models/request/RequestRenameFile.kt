package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestRenameFile {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("lastVersion")
    @Expose
    var lastVersion = 0
}