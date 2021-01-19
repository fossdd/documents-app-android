package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PathParts {
    @SerializedName("key")
    @Expose
    var key = ""

    @SerializedName("path")
    @Expose
    var path = ""
}