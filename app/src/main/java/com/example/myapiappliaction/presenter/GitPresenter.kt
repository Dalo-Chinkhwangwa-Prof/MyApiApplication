package com.example.myapiappliaction.presenter

import com.example.myapiappliaction.factory.GitFactory
import com.example.myapiappliaction.presenter.Contract.*
import com.example.myapiappliaction.model.RepoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPresenter(private val myView: ViewInterface) : PresenterInterface {

    private val gitService = GitFactory()

    override fun getGitRepos() {
        gitService.getGitRepos().enqueue(object : Callback<List<RepoResult>> {
            override fun onResponse(
                call: Call<List<RepoResult>>,
                response: Response<List<RepoResult>>
            ) {
                response.body()?.let { myRepos ->
                    myView.displayRepos(myRepos)
                }
            }

            override fun onFailure(call: Call<List<RepoResult>>, t: Throwable) {
                //log error using the infamous ErrorLogger
                myView.onFetchError()
            }
        })
    }

}