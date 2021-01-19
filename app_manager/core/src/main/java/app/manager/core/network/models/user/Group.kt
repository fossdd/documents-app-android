package app.manager.core.network.models.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Group : Serializable {

    @SerializedName("id")
    @Expose
    var id = ""

    @SerializedName("name")
    @Expose
    var name = ""

    @SerializedName("manager")
    @Expose
    var manager = ""

}