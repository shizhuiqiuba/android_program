package com.example.networktest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sendRequestBtn: Button = findViewById(R.id.sendRequestBtn)
        val responseText:TextView = findViewById(R.id.responseText)
        sendRequestBtn.setOnClickListener {
            sendRequestWithOkHttp()
        }
    }

    private fun sendRequestWithOkHttp() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder().url("http://www.baidu.com").build
                val response = client.newCall(request).execute()
                val responseData = response.bady?.string()
                if (responseData != null) {
                    showResponse(responseData)
                }
                catch(e: Exception) {
                    e.printStackTrace()
                }finally {
                    response?.disconnect()
                }
            }
        }
    private fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }
        }
    }













