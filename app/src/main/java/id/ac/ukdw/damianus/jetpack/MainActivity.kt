package id.ac.ukdw.damianus.jetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit1 = findViewById<Button>(R.id.tambah)
            submit1.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
    }
}