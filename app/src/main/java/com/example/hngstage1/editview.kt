package com.example.hngstage1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit)


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

        val fnameTextview = findViewById<TextView>(R.id.name)
        fnameTextview.text = fallbackFName

        val sNameTextView = findViewById<TextView>(R.id.slack)
        sNameTextView.text = fallbackSName

        val gNameTextview = findViewById<TextView>(R.id.github)
        gNameTextview.text = fallbackGName

        val bioTextview = findViewById<TextView>(R.id.bio)
        bioTextview.text = fallbackBio

        val openButton = findViewById<Button>(R.id.button) // Initialize the Button
        openButton.setOnClickListener {
            val editTextName = findViewById<EditText>(R.id.name)
            val editTextGithub = findViewById<EditText>(R.id.github)
            val editTextSlack = findViewById<EditText>(R.id.slack)
            val editTextBio = findViewById<EditText>(R.id.bio)

            val editedName = editTextName.text.toString()
            val editedGithub = editTextGithub.text.toString()
            val editedSlack = editTextSlack.text.toString()
            val editedBio = editTextBio.text.toString()

// Save the edited text to a shared preference
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("fname", editedName)
            editor.putString("slack_username", editedSlack)
            editor.putString("github_handle", editedGithub)
            editor.putString("bio", editedBio)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}