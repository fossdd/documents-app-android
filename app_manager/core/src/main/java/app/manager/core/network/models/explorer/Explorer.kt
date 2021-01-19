package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Explorer {
    @SerializedName("files")
    @Expose
    var files: List<CloudFile> = ArrayList()

    @SerializedName("folders")
    @Expose
    var folders: List<CloudFolder> = ArrayList()

    @SerializedName("current")
    @Expose
    var current: Current = Current()

    @SerializedName("pathParts")
    @Expose
    var pathParts: List<String> = ArrayList()

    @SerializedName("startIndex")
    @Expose
    var startIndex = ""

    @SerializedName("count")
    @Expose
    var count = 0

    @SerializedName("total")
    @Expose
    var total = 0

}