package id.ac.ukdw.damianus.jetpack

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firestore = FirebaseFirestore.getInstance()

        val judul = findViewById<EditText>(R.id.judul)
        val tanggal = findViewById<EditText>(R.id.tanggal)
        val isi = findViewById<EditText>(R.id.isi)
        val btn = findViewById<Button>(R.id.submit)

        btn.setOnClickListener{
            val tabel = table(judul.text.toString(), tanggal.text.toString() , isi.text.toString())
            firestore.collection( "Notes").add(tabel).addOnSuccessListener {
                Log.d(TAG, "Penyimpanan Berhasil")
            }.addOnFailureListener {
                Log.d(TAG, "Penyimpanan Gagal")
            }

        }


    }
}