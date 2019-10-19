package com.example.myapiappliaction.factory

import com.example.myapiappliaction.model.RepoResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    //Dalo-Chinkhwangwa-Prof/repos
    @GET("users/{user_name}/{item_type}")
    fun getMyRepositories(
        @Path("user_name") userName: String,
        @Path("item_type") itemType: String
    ): Call<List<RepoResult>>
}