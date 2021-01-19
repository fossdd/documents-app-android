package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class Operation {
    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("operation")
    @Expose
    var operation = 0

    @SerializedName("progress")
    @Expose
    var progress = 0

    @SerializedName("error")
    @Expose
    var error: String? = null

    @SerializedName("processed")
    @Expose
    var processed = ""

    @SerializedName("finished")
    @Expose
    var finished = false

    @SerializedName("url")
    @Expose
    var url = ""

    @SerializedName("files")
    @Expose
    var files: List<CloudFile>? = ArrayList()

    @SerializedName("folders")
    @Expose
    var folders: List<CloudFolder>? = ArrayList()

}