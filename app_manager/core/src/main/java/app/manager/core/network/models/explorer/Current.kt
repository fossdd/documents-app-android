package app.manager.core.network.models.explorer

import app.manager.core.network.Api
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Current {
    @SerializedName("parentId")
    @Expose
    var parentId = ""

    @SerializedName("filesCount")
    @Expose
    var filesCount = ""

    @SerializedName("foldersCount")
    @Expose
    var foldersCount = ""

    @SerializedName("isShareable")
    @Expose
    var isShareable = false

    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("title")
    @Expose
    var title = ""

    @SerializedName("access")
    @Expose
    var access: Int = Api.ShareCode.NONE

    @SerializedName("shared")
    @Expose
    var shared = false

    @SerializedName("rootFolderType")
    @Expose
    var rootFolderType: Int = Api.SectionType.UNKNOWN

    @SerializedName("updatedBy")
    @Expose
    var updatedBy = UpdatedBy()

    @SerializedName("created")
    @Expose
    var created = ""

    @SerializedName("createdBy")
    @Expose
    var createdBy = CreatedBy()

    @SerializedName("updated")
    @Expose
    var updated = ""

    @SerializedName("providerItem")
    @Expose
    var providerItem = false

}