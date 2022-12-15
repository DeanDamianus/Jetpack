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


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val firestore = FirebaseFirestore.getInstance()

        val titles = findViewById<EditText>(R.id.judul)
        val dates = findViewById<EditText>(R.id.tanggal)
        val content = findViewById<EditText>(R.id.isi)
        val buttons = findViewById<Button>(R.id.submit)

        buttons.setOnClickListener{
            val tables = table(titles.text.toString(), dates.text.toString() , content.text.toString())
            firestore.collection( "Jetpack").add(tables).addOnSuccessListener {
                Log.d(TAG, "Penyimpanan Behasil")
            }.addOnFailureListener {
                Log.d(TAG, "Penyimpanan Gagal")
            }

        }


    }
}