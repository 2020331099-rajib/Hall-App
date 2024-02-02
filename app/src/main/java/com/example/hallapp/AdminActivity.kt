package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AdminActivity : AppCompatActivity() {

    lateinit var arback : TextView
    lateinit var auser : TextView
    lateinit var upnoti : ImageView
    lateinit var UpdaStu: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        arback = findViewById(R.id.aback)
        arback.setOnClickListener {
            val intent = Intent(this@AdminActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        auser = findViewById(R.id.vuser)
        auser.setOnClickListener {
            val intent = Intent(this@AdminActivity, MainActivity4::class.java)
            startActivity(intent)
        }

        upnoti = findViewById(R.id.Upload_Not_act)
        upnoti.setOnClickListener {
            val intent = Intent(this@AdminActivity, UploadNotice::class.java)
            startActivity(intent)
        }

        UpdaStu = findViewById(R.id.StuActivity)
        UpdaStu.setOnClickListener {
            val intent = Intent(this@AdminActivity, StudentActivity::class.java)
            startActivity(intent)
        }
    }
}