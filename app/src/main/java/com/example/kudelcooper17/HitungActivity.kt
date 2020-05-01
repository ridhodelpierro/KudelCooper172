package com.example.kudelcooper17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_hitung.*

class HitungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        buttonHitung.setOnClickListener {
            var isEmptyField = false

            val stringPanjang = editPanjang.text.toString().trim()
            val stringLebar = editLebar.text.toString().trim()
            val stringTinggi = editTinggi.text.toString().trim()

            if (stringPanjang.equals("")){
                isEmptyField = true
                editPanjang.error = "Data Kosong"
            }
            if (stringLebar.isEmpty()){
                isEmptyField = true
                editLebar.error = "Data Kosong"
            }
            if (stringTinggi == ""){
                isEmptyField = true
                editTinggi.error = "Data Kosong"
            }
            if (!isEmptyField){

                val Panjang = stringPanjang.toFloat()
                val Lebar = stringLebar.toFloat()
                val Tinggi = stringTinggi.toFloat()

                textHasil.text = (Panjang * Panjang * Tinggi).toString()
            }
        }

    }
}
