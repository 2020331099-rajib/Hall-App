package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {

    lateinit var dyning : TextView
    lateinit var canteen : TextView
    lateinit var headlin : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        dyning = findViewById(R.id.dyni)
        dyning.setOnClickListener {
            val intent = Intent(this@MainActivity5, MainActivity6::class.java)
            startActivity(intent)
        }

        canteen = findViewById(R.id.cantenmen)
        canteen.setOnClickListener {
            val intent = Intent(this@MainActivity5, MainActivity7::class.java)
            startActivity(intent)
        }

        headlin = findViewById(R.id.headline)
        headlin.setOnClickListener {
            val intent = Intent(this@MainActivity5, MainActivity4::class.java)
            startActivity(intent)
        }

    }
}