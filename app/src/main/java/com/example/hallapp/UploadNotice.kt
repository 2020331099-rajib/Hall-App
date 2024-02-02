package com.example.hallapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import android.Manifest
import android.content.pm.PackageManager

class UploadNotice : AppCompatActivity() {

    private val storage = Firebase.storage
    private var selectedFileUri: Uri? = null
    private lateinit var noticeView: TextView

    companion object {
        private const val REQUEST_EXTERNAL_STORAGE = 1
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                selectedFileUri = data?.data

                // Update the TextView with the file name or URI
                selectedFileUri?.let {
                    // For example, displaying the last path segment (file name)
                    val fileName = it.lastPathSegment
                    noticeView.text = fileName ?: "File selected"
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_notice)

        val noticeTitleEditText: TextInputEditText = findViewById(R.id.Notice_title)
        val uploadButton: MaterialButton = findViewById(R.id.upload_No_btn)
        noticeView = findViewById(R.id.Notice_view)

        // Set an OnClickListener for the upload button
        uploadButton.setOnClickListener {
            val noticeTitle = noticeTitleEditText.text.toString().trim()

            // Check if the notice title is not empty and a file is selected
            if (noticeTitle.isNotEmpty() && selectedFileUri != null) {
                // Upload the file to Firebase Storage
                uploadFileToFirebaseStorage(noticeTitle, selectedFileUri!!)
            } else {
                Toast.makeText(this, "Please provide a title and select a file", Toast.LENGTH_SHORT).show()
            }
        }

        val textView: TextView = findViewById(R.id.select_file)
        textView.setOnClickListener {
            openFilePicker()
        }
    }

    private fun openFilePicker() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_EXTERNAL_STORAGE)
        } else {
            startFilePicker()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startFilePicker()
            } else {
                Toast.makeText(this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*" // All file types
        }
        getContent.launch(intent)
    }


    private fun uploadFileToFirebaseStorage(noticeTitle: String, fileUri: Uri) {
        val storageRef = storage.reference
        val noticeRef = storageRef.child("notices/$noticeTitle")

        // Upload file to Firebase Storage
        noticeRef.putFile(fileUri)
            .addOnSuccessListener {
                // File uploaded successfully, you can get the download URL
                noticeRef.downloadUrl.addOnSuccessListener { uri ->
                    // Now you can use the download URL for your requirements
                    val downloadUrl = uri.toString()
                    Toast.makeText(this, "File uploaded successfully!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                Toast.makeText(this, "Upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
