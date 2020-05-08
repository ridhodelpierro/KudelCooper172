package com.example.kudelcooper17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nama = intent.getStringExtra("Nama")
        val kelas = intent.getStringExtra("Kelas")
        textNama.text = nama
        textKelas.text = kelas
    }
}
