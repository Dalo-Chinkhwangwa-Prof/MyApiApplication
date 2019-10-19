package com.example.myapiappliaction.factory

import com.example.myapiappliaction.model.RepoResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GitFactory {
    val BASE_URL = "https://api.github.com/"

    private var gitService: GitService

    init {
        gitService = createGitService(getRetrofitInstance())
    }

    private fun createGitService(retrofitInstance: Retrofit): GitService {
        return retrofitInstance.create(GitService::class.java)
    }

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getGitRepos(): Call<List<RepoResult>> {
        return gitService.getMyRepositories("Dalo-Chinkhwangwa-Prof", "repos")
    }


}