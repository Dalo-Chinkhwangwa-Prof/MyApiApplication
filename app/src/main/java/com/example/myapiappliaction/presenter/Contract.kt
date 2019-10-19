package com.example.myapiappliaction.presenter

import com.example.myapiappliaction.model.RepoResult

interface Contract {
    interface PresenterInterface {
        fun getGitRepos()
    }
    interface ViewInterface {
        fun displayRepos(repositories: List<RepoResult>)
        fun onFetchError()
    }
}