package com.example.hngstage1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attempt to read from the shared preference
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val fname = sharedPreferences.getString("fname", null)
        val slackUsername = sharedPreferences.getString("slack_username", null)
        val githubHandle = sharedPreferences.getString("github_handle", null)
        val bio = sharedPreferences.getString("bio", null)

        // If the shared preference is empty, fall back to the resource value
        val fallbackFName = if (fname.isNullOrEmpty()) {
            getString(R.string.name)
        } else {
            fname
        }

        val fallbackSName = if (fname.isNullOrEmpty()) {
            getString(R.string.slack_name)
        } else {
            slackUsername
        }

        val fallbackGName = if (fname.isNullOrEmpty()) {
            getString(R.string.github_handle)
        } else {
            githubHandle
        }

        val fallbackBio = if (fname.isNullOrEmpty()) {
            getString(R.string.bio)
        } else {
            bio
        }

        val fnameTextview = findViewById<TextView>(R.id.the_fname)
        fnameTextview.text = fallbackFName

        val sNameTextView = findViewById<TextView>(R.id.slack_name)
        sNameTextView.text = fallbackSName

        val gNameTextview = findViewById<TextView>(R.id.github_name)
        gNameTextview.text = fallbackGName

        val bioTextview = findViewById<TextView>(R.id.bio)
        bioTextview.text = fallbackBio

        val openButton = findViewById<FloatingActionButton>(R.id.floatingActionButton) // Initialize the Button
        openButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }
}