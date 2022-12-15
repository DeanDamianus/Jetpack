package id.ac.ukdw.damianus.jetpack

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firestore = FirebaseFirestore.getInstance()

        val T = table("Judul", "12-12-2002", "Isi")
        firestore.collection( "Notes").add(T).addOnSuccessListener {
            Log.d(TAG, "penyimpanan selesai")
        }.addOnFailureListener {
            Log.d(TAG, "penyimpanan gagal")
        }
        var tambah = findViewById<Button>(R.id.tambah)
         tambah.setOnClickListener {
             val intent = Intent(this,MainActivity2::class.java)
             startActivity(intent)
         }
    }
}