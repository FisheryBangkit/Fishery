package com.bangkit.fishery_app.data.source.remote.retrofit

import androidx.room.Dao
import com.bangkit.fishery_app.data.source.remote.response.FishResponse
import com.bangkit.fishery_app.data.source.remote.response.FishResponseItem
import com.bangkit.fishery_app.data.source.remote.response.PostResponse
import com.bangkit.fishery_app.data.source.remote.response.PostResponseItem
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query


@Dao
interface ApiService {
    @GET("home/ikan")
    suspend fun getFishMenu() : List<FishResponseItem>

    @GET("marketplace/posts")
    suspend fun getPosts(): List<PostResponseItem>

    @GET("marketplace/posts")
    suspend fun getDetailPost(id: Int) : PostResponseItem

    @Multipart
    @POST("marketplace/add-post")
    suspend fun addPost(
        @Part("username") username: RequestBody?,
        @Part("userProfilePhoto") userProfilePhoto: RequestBody?,
        @Part("title") title: RequestBody,
        @Part("description") description: RequestBody,
        @Part("location") location: RequestBody,
        @Part("phoneNumber") phoneNumber: RequestBody,
        @Part("price") price: RequestBody,
        @Part photo: MultipartBody.Part?,
    ): PostResponseItem

}