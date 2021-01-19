package app.manager.core.network.models.explorer

import app.manager.core.network.Api
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

open class Item {
    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("title")
    @Expose
    var title = ""

    @SerializedName("access")
    @Expose
    var access = Api.ShareCode.NONE

    @SerializedName("shared")
    @Expose
    var shared = false

    @SerializedName("rootFolderType")
    @Expose
    var rootFolderType = ""

    @SerializedName("updatedBy")
    @Expose
    var updatedBy = UpdatedBy()

    @SerializedName("created")
    @Expose
    var created = Date()

    @SerializedName("createdBy")
    @Expose
    var createdBy = CreatedBy()

    @SerializedName("updated")
    @Expose
    var updated = Date()

    @SerializedName("providerItem")
    @Expose
    var providerItem = false

}