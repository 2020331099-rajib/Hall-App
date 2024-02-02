package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class StudentActivity : AppCompatActivity() {

    lateinit var UpodImg: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        UpodImg = findViewById(R.id.upload_img_btn)
        UpodImg.setOnClickListener {
            val intent = Intent(this@StudentActivity, UploadImage::class.java)
            startActivity(intent)
        }
    }
}