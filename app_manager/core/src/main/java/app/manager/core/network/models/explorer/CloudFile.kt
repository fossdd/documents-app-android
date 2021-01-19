package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CloudFile : Item() {
    @SerializedName("folderId")
    @Expose
    var folderId = ""

    @SerializedName("version")
    @Expose
    var version = 0

    @SerializedName("versionGroup")
    @Expose
    var versionGroup = ""

    @SerializedName("contentLength")
    @Expose
    var contentLength = ""

    @SerializedName("pureContentLength")
    @Expose
    var pureContentLength: Long = 0

    @SerializedName("fileStatus")
    @Expose
    var fileStatus = ""

    @SerializedName("viewUrl")
    @Expose
    var viewUrl = ""

    @SerializedName("webUrl")
    @Expose
    var webUrl = ""

    @SerializedName("fileType")
    @Expose
    var fileType = ""

    @SerializedName("fileExst")
    @Expose
    var fileExst = ""

    @SerializedName("comment")
    @Expose
    var comment = ""

}