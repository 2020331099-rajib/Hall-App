package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {

    lateinit var authority : TextView
    lateinit var notice : TextView
    lateinit var office : TextView
    lateinit var students : TextView
    lateinit var foods : TextView
    lateinit var medicin : TextView
    lateinit var services : TextView
    lateinit var complaints : TextView
    lateinit var sports : TextView
    lateinit var contacts : TextView
    lateinit var arback : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        arback = findViewById(R.id.headline)
        arback.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity2::class.java)
            startActivity(intent)
        }

        authority = findViewById(R.id.authority)
        authority.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity14::class.java)
            startActivity(intent)        }

        notice = findViewById(R.id.notice)
        notice.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity15::class.java)
            startActivity(intent)        }

        office = findViewById(R.id.office)
        office.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity16::class.java)
            startActivity(intent)        }

        students = findViewById(R.id.students)
        students.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity12::class.java)
            startActivity(intent)
        }

        foods = findViewById(R.id.foods)
        foods.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity5::class.java)
            startActivity(intent)
        }

        medicin = findViewById(R.id.medicin)
        medicin.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity8::class.java)
            startActivity(intent)
        }

        services = findViewById(R.id.services)
        services.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity13::class.java)
            startActivity(intent)        }

        complaints = findViewById(R.id.complaints)
        complaints.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity11::class.java)
            startActivity(intent)        }

        sports = findViewById(R.id.sports)
        sports.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity9::class.java)
            startActivity(intent)        }

        contacts = findViewById(R.id.contacts)
        contacts.setOnClickListener {
            val intent = Intent(this@MainActivity4, MainActivity10::class.java)
            startActivity(intent)        }
    }
}
