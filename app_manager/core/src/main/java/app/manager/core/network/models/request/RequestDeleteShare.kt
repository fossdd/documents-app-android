package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class RequestDeleteShare {
    @SerializedName("folderIds")
    @Expose
    var folderIds: List<String> = ArrayList()

    @SerializedName("fileIds")
    @Expose
    var fileIds: List<String> = ArrayList()
}