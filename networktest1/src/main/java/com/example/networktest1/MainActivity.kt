package com.example.networktest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView:WebView=findViewById(R.id.webView)
        val getWebViewBtn:Button=findViewById(R.id.getWebViewBtn)
        webView.settings.javaScriptEnabled=true
        getWebViewBtn.setOnClickListener{
            webView.webViewClient= WebViewClient()
            webView.loadUrl("https://www.baidu.com")
        }

    }
}