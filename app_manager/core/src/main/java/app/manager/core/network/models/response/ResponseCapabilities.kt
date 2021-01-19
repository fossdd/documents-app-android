/*
 * Created by Michael Efremov on 10.09.20 13:27
 */

package app.manager.core.network.models.response

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.base.Capabilities
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseCapabilities : Base() {

    @SerializedName(KEY_RESPONSE)
    @Expose
    var response: Capabilities? = null

}