package app.manager.core.network.models.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestUser {
    enum class Sex {
        MALE, FEMALE
    }

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null

    @SerializedName("sex")
    @Expose
    var sex: String? = null

    @SerializedName("files")
    @Expose
    var avatar: String? = null

    companion object {
        fun getSex(sex: Sex?): String? {
            when (sex) {
                Sex.MALE -> return "male"
                Sex.FEMALE -> return "female"
            }
            return null
        }
    }
}