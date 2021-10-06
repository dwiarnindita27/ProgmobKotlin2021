package com.example.progmobkotlin21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    lateinit var btnGetAPI : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnGetAPI = findViewById(R.id.btnGetAPI)

        btnGetAPI.setOnClickListener(View.OnClickListener { View ->
            var intent = Intent(this@ServiceActivity, GetAPIActivity::class.java)
            startActivity(intent)
    })
}
}