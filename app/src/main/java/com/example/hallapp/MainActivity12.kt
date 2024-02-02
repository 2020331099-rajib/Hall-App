package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity12 : AppCompatActivity() {

    lateinit var headlin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)

        headlin = findViewById(R.id.headline)
        headlin.setOnClickListener {
            val intent = Intent(this@MainActivity12, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}