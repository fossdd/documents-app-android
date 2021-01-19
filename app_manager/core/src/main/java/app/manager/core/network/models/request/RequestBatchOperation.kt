package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestBatchOperation : RequestBatchBase() {
    @SerializedName("destFolderId")
    @Expose
    var destFolderId: String? = null

    @SerializedName("conflictResolveType")
    @Expose
    var conflictResolveType: String? = null
}