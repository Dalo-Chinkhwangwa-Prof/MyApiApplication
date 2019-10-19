package com.example.myapiappliaction.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapiappliaction.R
import com.example.myapiappliaction.presenter.Contract.*
import com.example.myapiappliaction.presenter.GitPresenter
import com.example.myapiappliaction.model.RepoResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {

    private lateinit var myPresenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myPresenter = GitPresenter(this)

        repo_button.setOnClickListener {
            myPresenter.getGitRepos()
        }
    }

    override fun displayRepos(repositories: List<RepoResult>) {

        val stringBuilder = StringBuilder()
        repositories.forEach { repo ->
            stringBuilder.append("${repo.name}\n")
        }

        my_main_textview.text = stringBuilder.toString()

    }

    override fun onFetchError() {
        Toast.makeText(this, "Error fetching results", Toast.LENGTH_SHORT).show()
    }
}
