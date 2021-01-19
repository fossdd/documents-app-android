package app.manager.core.network.factory

import com.google.gson.GsonBuilder
import lib.toolkit.base.managers.utils.TimeUtils
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.lang.reflect.Type


class ConverterFactory : Converter.Factory() {

    @Retention(AnnotationRetention.RUNTIME)
    annotation class Json

    @Retention(AnnotationRetention.RUNTIME)
    annotation class Xml

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody?, *>? {
        for (annotation in annotations) {
            if (annotation.annotationClass == Xml::class.java) {
                return SimpleXmlConverterFactory.create().responseBodyConverter(type, annotations, retrofit)
            } else if (annotation.annotationClass == Json::class.java) {
                return getGsonConverter().responseBodyConverter(type, annotations, retrofit)
            }
        }
        return getGsonConverter().responseBodyConverter(type, annotations, retrofit)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit?
    ): Converter<*, RequestBody?>? {
        for (annotation in methodAnnotations) {
            if (annotation.annotationClass == Xml::class.java) {
                return SimpleXmlConverterFactory.create()
                    .requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
            } else if (annotation.annotationClass == Json::class.java) {
                return getGsonConverter().requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
            }
        }
        return getGsonConverter().requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    private fun getGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .setDateFormat(TimeUtils.OUTPUT_PATTERN_DEFAULT)
                .serializeNulls()
                .create()
        )
    }

}