package com.example.hngstage1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        val webView = findViewById<WebView>(R.id.webview)
        webView.webViewClient = WebViewClient()

        val url = "https://github.com/technicaldee" // Replace with the URL you want to open
        webView.loadUrl(url)
    }
}