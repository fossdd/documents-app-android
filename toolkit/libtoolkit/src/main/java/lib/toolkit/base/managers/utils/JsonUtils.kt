package lib.toolkit.base.managers.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


object JsonUtils {

    private const val FORMULAS_PATH = "formulas/"
    private const val JSON_EXTENSION = ".json"
    private const val DESC_SUFFIX = "_desc"

    @JvmStatic
    fun jsonFromAssets(context: Context, path: String): String {
        context.assets.open(path).use {
            return String(it.readBytes())
        }
    }

    @JvmStatic
    fun <T> jsonAssetsToCollection(context: Context, assets: String, clazz: Class<T>): T {
        return jsonToObject(jsonFromAssets(context, assets), clazz)
    }

    @JvmStatic
    fun <T> objectToJson(data: T): String {
        return Gson().toJson(data, object : TypeToken<T>() {}.type)
    }

    @JvmStatic
    fun <T> objectToJsonExpose(data: T): String {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
                .toJson(data, object : TypeToken<T>() {}.type)
    }

    @JvmStatic
    fun <T> jsonToObject(json: String, clazz: Class<T>): T {
        return Gson().fromJson(json, clazz)
    }

    @JvmStatic
    fun <T> jsonToObjectExpose(json: String, clazz: Class<T>): T? {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
                .fromJson(json, clazz)
    }

    @JvmStatic
    fun jsonToMap(jsonObject: JSONObject): HashMap<*, *> {
        return Gson().fromJson(jsonObject.toString(), HashMap::class.java)
    }

    fun jsonToMapReverse(jsonObject: JSONObject?): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        jsonObject?.let {
            val keys = jsonObject.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                val value = jsonObject[key]
                if (value is JSONArray) {
                    continue
                } else if (value is JSONObject) {
                    continue
                }
                map[value.toString()] = key
            }
            return map
        }
        return map
    }

    fun getFormulasJson(context: Context): JSONObject? {
        return try {
            JSONObject(jsonFromAssets(context, FORMULAS_PATH + StringUtils.getLang() + JSON_EXTENSION))
        } catch (exception: JSONException) {
            return null
        }
    }

    fun getFormulasDescJson(context: Context): JSONObject? {
        return try {
            JSONObject(jsonFromAssets(context, FORMULAS_PATH + StringUtils.getLang() + DESC_SUFFIX + JSON_EXTENSION))
        } catch (exception: JSONException) {
            return null
        }
    }

}