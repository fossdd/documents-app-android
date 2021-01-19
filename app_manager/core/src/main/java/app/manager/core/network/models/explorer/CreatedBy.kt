package app.manager.core.network.models.explorer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CreatedBy : UpdatedBy() {
    @SerializedName("title")
    @Expose
    var title = ""

}