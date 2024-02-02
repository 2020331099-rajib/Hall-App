package com.example.hallapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class UploadImage : AppCompatActivity() {

    private lateinit var noticeImgView: ImageView
    private lateinit var noticeTitle: EditText
    private lateinit var progressBar: ProgressBar
    private var bitmap: Bitmap? = null
    private val databaseReference = FirebaseDatabase.getInstance().getReference("Notice")
    private val storageReference = FirebaseStorage.getInstance().getReference("Images")

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val imageUri = result.data?.data
            imageUri?.let { uri ->
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                noticeImgView.setImageBitmap(bitmap)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        progressBar = ProgressBar(this)
        noticeImgView = findViewById(R.id.Notice_img_view)
        noticeTitle = findViewById(R.id.Notice_title)
        val uploadBtn: Button = findViewById(R.id.upload_img_btn)

        findViewById<ImageView>(R.id.Addimge).setOnClickListener {
            openGallery()
        }

        uploadBtn.setOnClickListener {
            val title = noticeTitle.text.toString().trim()
            when {
                title.isEmpty() -> {
                    noticeTitle.error = "Please enter a title"
                    noticeTitle.requestFocus()
                }
                bitmap == null -> {
                    Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    uploadImage()
                }
            }
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(galleryIntent)
    }

    private fun uploadImage() {
        progressBar.visibility = ProgressBar.VISIBLE
        val baos = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 50, baos)
        val finalImg = baos.toByteArray()

        val filePath = storageReference.child(System.currentTimeMillis().toString() + ".jpg")
        filePath.putBytes(finalImg).addOnCompleteListener { task ->
            progressBar.visibility = ProgressBar.GONE
            if (task.isSuccessful) {
                filePath.downloadUrl.addOnSuccessListener { uri ->
                    uploadData(uri.toString())
                }
            } else {
                task.exception?.message?.let {
                    Toast.makeText(this, "Upload failed: $it", Toast.LENGTH_SHORT).show()
                }
            }
        }.addOnFailureListener {
            progressBar.visibility = ProgressBar.GONE
            Toast.makeText(this, "Upload failed: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadData(downloadUrl: String) {
        val title = noticeTitle.text.toString()
        val uniqueKey = databaseReference.push().key ?: ""
        val currentDate = SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())

        val noticeData = NoticeData(title, downloadUrl, currentDate, currentTime, uniqueKey)

        databaseReference.child(uniqueKey).setValue(noticeData).addOnSuccessListener {
            Toast.makeText(this, "Notice uploaded", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}
