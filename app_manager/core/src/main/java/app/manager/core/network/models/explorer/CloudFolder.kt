package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CloudFolder : Item() {
    @SerializedName("parentId")
    @Expose
    var parentId = ""

    @SerializedName("filesCount")
    @Expose
    var filesCount = 0

    @SerializedName("foldersCount")
    @Expose
    var foldersCount = 0

    @SerializedName("providerKey")
    @Expose
    var providerKey = ""
    var etag = ""

}