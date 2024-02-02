package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.hallapp.R

class MainActivity3 : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var signin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        signin = findViewById(R.id.login_btn)

        signin.setOnClickListener(){
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            //Log.i("Test Credentials","Username: $username and Password : $password")

            val intent = Intent(this@MainActivity3, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}