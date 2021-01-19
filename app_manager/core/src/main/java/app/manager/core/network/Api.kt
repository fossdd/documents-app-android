package app.manager.core.network

import app.manager.core.network.models.base.Base
import app.manager.core.network.models.request.*
import app.manager.core.network.models.response.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {

    object Errors {
        const val AUTH = "User authentication failed"
        const val PORTAL_EXIST = "Portal already exist"
        const val SMS_TO_MANY = "You have sent too many text messages"
        const val DISK_SPACE_QUOTA = "Disk space quota exceeded"
    }

    object HttpCodes {
        const val NONE = -1
        const val SUCCESS = 200
        const val REDIRECTION = 300
        const val CLIENT_ERROR = 400
        const val CLIENT_UNAUTHORIZED = 401
        const val CLIENT_PAYMENT_REQUIRED = 402
        const val CLIENT_FORBIDDEN = 403
        const val CLIENT_NOT_FOUND = 404
        const val SERVER_ERROR = 500
    }

    object Parameters {
        const val ARG_ACTION = "action"
        const val ARG_COUNT = "count"
        const val ARG_START_INDEX = "startIndex"
        const val ARG_SORT_BY = "sortBy"
        const val ARG_SORT_ORDER = "sortOrder"
        const val ARG_FILTER_BY = "filterBy"
        const val ARG_FILTER_OP = "filterOp"
        const val ARG_FILTER_VALUE = "filterValue"
        const val ARG_UPDATED_SINCE = "updatedSince"
        const val VAL_ACTION_VIEW = "view"
        const val VAL_SORT_ORDER_ASC = "ascending"
        const val VAL_SORT_ORDER_DESC = "descending"
        const val VAL_FILTER_OP_CONTAINS = "contains"
        const val VAL_FILTER_OP_EQUALS = "equals"
        const val VAL_FILTER_OP_STARTS_WITH = "startsWith"
        const val VAL_FILTER_OP_PRESENT = "present"
        const val VAL_FILTER_BY = "title"
        const val VAL_SORT_BY_UPDATED = "DateAndTime"
        const val VAL_SORT_BY_CREATED = "created"
        const val VAL_SORT_BY_TITLE = "title"
        const val VAL_SORT_BY_TYPE = "type"
        const val VAL_SORT_BY_SIZE = "size"
        const val VAL_SORT_BY_OWNER = "Author"
    }

    object Extension {
        const val DOCX = "DOCX"
        const val XLSX = "XLSX"
        const val PPTX = "PPTX"
    }

    object ShareType {
        const val NONE = "None"
        const val READ_WRITE = "ReadWrite"
        const val READ = "Read"
        const val RESTRICT = "Restrict"
        const val VARIES = "Varies"
        const val REVIEW = "Review"
        const val COMMENT = "Comment"
        const val FILL_FORMS = "FillForms"
        fun getCode(type: String?): Int {
            return when (type) {
                NONE -> ShareCode.NONE
                READ_WRITE -> ShareCode.READ_WRITE
                READ -> ShareCode.READ
                RESTRICT -> ShareCode.RESTRICT
                VARIES -> ShareCode.VARIES
                REVIEW -> ShareCode.REVIEW
                COMMENT -> ShareCode.COMMENT
                FILL_FORMS -> ShareCode.FILL_FORMS
                else -> ShareCode.NONE
            }
        }
    }

    object ShareCode {
        const val NONE = 0
        const val READ_WRITE = 1
        const val READ = 2
        const val RESTRICT = 3
        const val VARIES = 4
        const val REVIEW = 5
        const val COMMENT = 6
        const val FILL_FORMS = 7
        fun getType(code: Int): String {
            return when (code) {
                NONE -> ShareType.NONE
                READ_WRITE -> ShareType.READ_WRITE
                READ -> ShareType.READ
                RESTRICT -> ShareType.RESTRICT
                VARIES -> ShareType.VARIES
                REVIEW -> ShareType.REVIEW
                else -> ShareType.NONE
            }
        }
    }

    object SectionType {
        const val UNKNOWN = 0
        const val CLOUD_COMMON = 1
        const val CLOUD_BUNCH = 2
        const val CLOUD_TRASH = 3
        const val CLOUD_USER = 5
        const val CLOUD_SHARE = 6
        const val CLOUD_PROJECTS = 8
        const val DEVICE_DOCUMENTS = 9
    }

    object FileStatus {
        const val NONE = 0x0
        const val IS_EDITING = 0x1
        const val IS_NEW = 0x2
        const val IS_CONVERTING = 0x4
        const val IS_ORIGINAL = 0x8
        const val BACKUP = 0x10
    }

    object Storage {
        const val BOXNET = "Box"
        const val DROPBOX = "DropboxV2"
        const val GOOGLEDRIVE = "GoogleDrive"
        const val ONEDRIVE = "OneDrive"
        const val SKYDRIVE = "SkyDrive"
        const val GOOGLE = "Google"
        const val SHAREPOINT = "SharePoint"
        const val YANDEX = "Yandex"
        const val OWNCLOUD = "OwnCloud"
        const val NEXTCLOUD = "Nextcloud"
        const val WEBDAV = "WebDav"
    }

    object Operation {
        const val SKIP = 0
        const val OVERWRITE = 1
        const val DUPLICATE = 2
    }

    object Social {
        const val TWITTER = "twitter"
        const val FACEBOOK = "facebook"
        const val GOOGLE = "google"
    }

    companion object {
        /*
         * Api constants
         * */
        const val API_VERSION = "2.0"
        const val SCHEME_HTTPS = "https://"
        const val SCHEME_HTTP = "http://"
        const val API_SUBDOMAIN = "api-system"
        const val PERSONAL_SUBDOMAIN = "personal"
        const val DEFAULT_HOST = "onlyoffice.com"
        const val PERSONAL_HOST = "$PERSONAL_SUBDOMAIN.$DEFAULT_HOST"
        const val RESPONSE_FORMAT = ".json"

        /*
         * Portals versions
         * */
        const val PORTAL_VERSION_10 = "10.0.0.297"

        /*
         * Headers
         * */
        const val HEADER_AUTHORIZATION = "Authorization"
        const val HEADER_HOST = "Host"
        const val HEADER_CONTENT_TYPE = "Content-OperationType"
        const val HEADER_ACCEPT = "Accept"
        const val HEADER_AGENT = "User-Agent"
        const val HEADER_CACHE = "Cache-Control"

        const val VALUE_CONTENT_TYPE = "application/json"
        const val VALUE_ACCEPT = "application/json"
        const val VALUE_CACHE = "no-cache"

        const val DOWNLOAD_ZIP_NAME = "download.zip"
    }

    /*
     * Sign in
     * */
    @Headers(
        "$HEADER_CACHE:$VALUE_CACHE",
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE", "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/authentication$RESPONSE_FORMAT")
    suspend fun signIn(@Body body: RequestSignIn?): ResponseSignIn

    /*
     * Check portal
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/capabilities$RESPONSE_FORMAT")
    suspend fun capabilities(): ResponseCapabilities

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/thirdparty/capabilities$RESPONSE_FORMAT")
    suspend fun getThirdpartyCapabilities(@Header(HEADER_AUTHORIZATION) token: String?): ResponseBody

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/thirdparty$RESPONSE_FORMAT")
    suspend fun getThirdPartyList(@Header(HEADER_AUTHORIZATION) token: String?): ResponseThirdparty

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/settings/version/build$RESPONSE_FORMAT")
    suspend fun getSettings(): ResponseSettings

    /*
     * Auth with SMS code
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/authentication/{sms_code}$RESPONSE_FORMAT")
    suspend fun smsSignIn(
        @Body body: RequestSignIn?,
        @Path(value = "sms_code") smsCode: String?
    ): ResponseSignIn

    /*
     * Resend SMS code
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/authentication/sendsms$RESPONSE_FORMAT")
    suspend fun sendSms(@Body body: RequestSignIn?): ResponseSignIn

    /*
     * Change number
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/authentication/setphone$RESPONSE_FORMAT")
    suspend fun changeNumber(@Body body: RequestNumber?): ResponseSignIn

    /*
     * Validate portal
     * */
    @Headers("$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE")
    @POST("/api/portal/validateportalname")
    suspend fun validatePortal(@Body body: RequestValidatePortal?): ResponseValidatePortal

    /*
     * Register portal
     * */
    @Headers("$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE")
    @POST("/api/portal/register")
    suspend fun registerPortal(@Body body: RequestRegister?): ResponseRegisterPortal

    /*
     * Register personal portal
     * */
    @Headers("$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE")
    @POST("api/$API_VERSION/authentication/register$RESPONSE_FORMAT")
    suspend fun registerPersonalPortal(@Body body: RequestRegister?): ResponseRegisterPersonalPortal

    /*
     * Counts of users
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/portal/userscount$RESPONSE_FORMAT")
    suspend fun getCountUsers(@Header(HEADER_AUTHORIZATION) token: String?): ResponseCount

    /*
     * Users info
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/people/@self$RESPONSE_FORMAT")
    suspend fun getUserInfo(@Header(HEADER_AUTHORIZATION) token: String?): ResponseUser

    //
    /*
     * Get folder/files by id
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/{item_id}$RESPONSE_FORMAT")
    suspend fun getItemById(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "item_id") folderId: String?,
        @QueryMap options: Map<String?, String?>?
    ): ResponseExplorer

    /*
     * Create docs file
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/files/{folder_id}/file$RESPONSE_FORMAT")
    suspend fun createDocs(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Body body: RequestCreate?
    ): ResponseCreateFile

    /*
     * Get file info
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/file/{file_id}$RESPONSE_FORMAT")
    suspend fun getFileInfo(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "file_id") fileId: String?
    ): ResponseFile

    /*
     * Create folder
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/files/folder/{folder_id}$RESPONSE_FORMAT")
    suspend fun createFolder(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Body body: RequestCreate?
    ): ResponseCreateFolder

    /*
     * Operation batch
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/fileops/delete$RESPONSE_FORMAT")
    suspend fun deleteBatch(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Body body: RequestBatchBase?
    ): ResponseOperation

    /*
     * Move items
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/fileops/move$RESPONSE_FORMAT")
    suspend fun move(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Body body: RequestBatchOperation?
    ): ResponseOperation

    /*
     * Copy items
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/fileops/copy$RESPONSE_FORMAT")
    suspend fun copy(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Body body: RequestBatchOperation?
    ): ResponseOperation

    /*
     * Terminate all operations
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/fileops/terminate$RESPONSE_FORMAT")
    suspend fun terminate(@Header(HEADER_AUTHORIZATION) token: String?): ResponseOperation

    /*
     * Status operations
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/fileops$RESPONSE_FORMAT")
    suspend fun status(@Header(HEADER_AUTHORIZATION) token: String?): ResponseOperation

    /*
     * Rename folder
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/folder/{folder_id}$RESPONSE_FORMAT")
    suspend fun renameFolder(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Body body: RequestTitle?
    ): ResponseFolder

    /*
     * Rename file
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/file/{file_id}$RESPONSE_FORMAT")
    suspend fun renameFile(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "file_id") folderId: String?,
        @Body body: RequestRenameFile?
    ): ResponseFile

    /*
     * Get share folder
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/folder/{folder_id}/share$RESPONSE_FORMAT")
    suspend fun getShareFolder(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?
    ): ResponseShare

    /*
     * Get share file
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/file/{file_id}/share$RESPONSE_FORMAT")
    suspend fun getShareFile(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "file_id") fileId: String?
    ): ResponseShare

    /*
     * Get external link
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/{file_id}/sharedlink$RESPONSE_FORMAT")
    suspend fun getExternalLink(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "file_id") fileId: String?,
        @Body body: RequestExternal?
    ): ResponseExternal

    /*
     * Set access for folder
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/folder/{folder_id}/share$RESPONSE_FORMAT")
    suspend fun setFolderAccess(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") fileId: String?,
        @Body body: RequestShare?
    ): ResponseShare

    /*
     * Set access for file
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/file/{file_id}/share$RESPONSE_FORMAT")
    suspend fun setFileAccess(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "file_id") fileId: String?,
        @Body body: RequestShare?
    ): ResponseShare

    /*
     * Delete share setting
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @HTTP(method = "DELETE", path = "api/$API_VERSION/files/share$RESPONSE_FORMAT", hasBody = true)
    suspend fun deleteShare(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Body body: RequestDeleteShare?
    ): Base

    /*
     * Get groups
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/group$RESPONSE_FORMAT")
    suspend fun getGroups(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @QueryMap options: Map<String?, String?>?
    ): ResponseGroups

    /*
     * Get users
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/people$RESPONSE_FORMAT")
    suspend fun getUsers(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @QueryMap options: Map<String?, String?>?
    ): ResponseUsers

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/people/{user_id}$RESPONSE_FORMAT")
    suspend fun updateUser(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "user_id") userId: String?,
        @Body body: RequestUser?
    ): ResponseUser

    /*
     * Get portal
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/portal$RESPONSE_FORMAT")
    suspend fun getPortal(@Header(HEADER_AUTHORIZATION) token: String?): ResponsePortal

    /*
     * Empty trash
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @PUT("api/$API_VERSION/files/fileops/emptytrash$RESPONSE_FORMAT")
    suspend fun emptyTrash(@Header(HEADER_AUTHORIZATION) token: String?): ResponseOperation

    /*
     * Connect storage
     * */
    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @POST("api/$API_VERSION/files/thirdparty$RESPONSE_FORMAT")
    suspend fun connectStorage(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Body body: RequestStorage?
    ): ResponseFolder

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @DELETE("api/$API_VERSION/files/thirdparty/{folder_id}$RESPONSE_FORMAT")
    suspend fun deleteStorage(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") id: String?
    ): ResponseBody

    /*
     * Download file
     * */
    @Streaming
    @GET
    suspend fun downloadFile(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Url url: String?
    ): ResponseBody

    /*
     * Upload  file
     * */
    @Multipart
    @POST("api/$API_VERSION/files/{folder_id}/upload$RESPONSE_FORMAT")
    suspend fun uploadFile(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Part part: MultipartBody.Part?
    ): ResponseFile

    @Multipart
    @POST("api/$API_VERSION/files/{folder_id}/upload$RESPONSE_FORMAT")
    suspend fun uploadMultiFiles(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Part part: Array<MultipartBody.Part?>?
    ): ResponseBody

    @Multipart
    @POST("api/$API_VERSION/files/@my/upload$RESPONSE_FORMAT")
    suspend fun uploadFileToMy(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Part part: MultipartBody.Part?
    ): ResponseFile

    /*
     * Insert  file
     * */
    @Multipart
    @POST("api/$API_VERSION/files/{folder_id}/insert$RESPONSE_FORMAT")
    suspend fun insertFile(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Path(value = "folder_id") folderId: String?,
        @Part("title") title: String?,
        @Part part: MultipartBody.Part?
    ): ResponseFile

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/files/fileops/move$RESPONSE_FORMAT")
    suspend fun checkFiles(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Query("destFolderId") destFolderId: String?,
        @Query("folderIds") folderIds: List<String?>?,
        @Query("fileIds") fileIds: List<String?>?
    ): ResponseFiles

    @Headers(
        "$HEADER_CONTENT_TYPE: $VALUE_CONTENT_TYPE",
        "$HEADER_ACCEPT: $VALUE_ACCEPT"
    )
    @GET("api/$API_VERSION/settings/security$RESPONSE_FORMAT")
    suspend fun getModules(
        @Header(HEADER_AUTHORIZATION) token: String?,
        @Query("ids") modulesIds: List<String?>?
    ): ResponseModules

}