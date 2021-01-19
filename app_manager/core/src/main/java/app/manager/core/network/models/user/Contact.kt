package app.manager.core.network.models.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Contact {
    @SerializedName("type")
    @Expose
    var type = ""

    @SerializedName("value")
    @Expose
    var value = ""
}