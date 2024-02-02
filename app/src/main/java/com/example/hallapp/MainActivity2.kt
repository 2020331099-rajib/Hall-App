package com.example.hallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn: Button
    lateinit var backBtn: Button
    lateinit var signin: Button
    lateinit var admin: Button


    var Admin_username : String = "RAJIBROBIDAS"
    var Admin_password : String = "RAJIBROBIDAS"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)
        backBtn = findViewById(R.id.back_btn)
        signin = findViewById(R.id.sign_up_btn)
        admin = findViewById(R.id.sign_up_bt)


        loginBtn.setOnClickListener(){
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            //Log.i("Test Credentials","Username: $username and Password : $password")

            if ( username == Admin_username && password == Admin_password ) {
                val intent = Intent(this@MainActivity2, AdminActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this@MainActivity2, MainActivity4::class.java)
                startActivity(intent)
            }

        }
        backBtn.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(intent)
        }
        admin.setOnClickListener {
            val intent = Intent(this@MainActivity2, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}