package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity4 : AppCompatActivity() {

    lateinit var authority : CardView
    lateinit var notice : CardView
    lateinit var office : CardView
    lateinit var students : CardView
    lateinit var foods : CardView
    lateinit var medicin : CardView
    lateinit var services : CardView
    lateinit var complaints : CardView
    lateinit var sports : CardView
    lateinit var contacts : CardView
    lateinit var arback : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        arback = findViewById(R.id.headline)
        arback.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity2::class.java)
            startActivity(intent)
        }

        authority = findViewById(R.id.autho)
        authority.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity14::class.java)
            startActivity(intent)        }

        notice = findViewById(R.id.noti)
        notice.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity15::class.java)
            startActivity(intent)        }

        office = findViewById(R.id.offi)
        office.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity16::class.java)
            startActivity(intent)        }

        students = findViewById(R.id.stu)
        students.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity12::class.java)
            startActivity(intent)
        }

        foods = findViewById(R.id.foo)
        foods.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity5::class.java)
            startActivity(intent)
        }

        medicin = findViewById(R.id.medi)
        medicin.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity8::class.java)
            startActivity(intent)
        }

        services = findViewById(R.id.serv)
        services.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity13::class.java)
            startActivity(intent)        }

        complaints = findViewById(R.id.comp)
        complaints.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity11::class.java)
            startActivity(intent)        }

        sports = findViewById(R.id.spo)
        sports.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity9::class.java)
            startActivity(intent)        }

        contacts = findViewById(R.id.con)
        contacts.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity10::class.java)
            startActivity(intent)        }
    }
}
