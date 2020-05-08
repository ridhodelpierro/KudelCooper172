package com.example.kudelcooper17

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

private const val Batu = 1
private const val Gunting = 2
private const val Kertas = 3


class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var pilihankomputer:Int
        var pilihanplayer:Int

        buttonBatu.setOnClickListener {
            pilihanplayer = Batu
            pilihankomputer = getpilihanKomputer()
            textHasil.text = suwit(pilihanplayer,pilihankomputer)
            textPlayer.text = "Batu"
            showpilihankomputer(pilihankomputer)
        }
        buttonGunting.setOnClickListener {
            pilihanplayer = Gunting
            pilihankomputer = getpilihanKomputer()
            textHasil.text = suwit(pilihanplayer,pilihankomputer)
            textPlayer.text = "Gunting"
            showpilihankomputer(pilihankomputer)
        }
        buttonKertas.setOnClickListener {
            pilihanplayer = Kertas
            pilihankomputer = getpilihanKomputer()
            textHasil.text = suwit(pilihanplayer,pilihankomputer)
            textPlayer.text = "Kertas"
            showpilihankomputer(pilihankomputer)
        }

    }

    fun getpilihanKomputer():Int{
        return java.util.Random().nextInt(3) + 1;
    }

    fun suwit(pilihanplayer:Int,pilihankomputer:Int):String{
        var hasil: String= ""
        if(pilihanplayer == pilihankomputer){
            hasil = "SERI"
            textHasil.setTextColor(Color.GRAY)
        }
        else if((pilihanplayer == Batu && pilihankomputer == Kertas) ||
                (pilihanplayer == Gunting && pilihankomputer == Batu) ||
                (pilihanplayer == Kertas && pilihankomputer == Gunting)){
            hasil = "YOU LOSE"
            textHasil.setTextColor(Color.RED)
        }
        else{
            hasil = "YOU WIN"
            textHasil.setTextColor(Color.GREEN)
        }

        return hasil

    }

    fun showpilihankomputer(pilihankomputer: Int){
        when(pilihankomputer){
            1 -> textKomputer.text = "Komputer memilih: Batu"
            2 -> textKomputer.text = "Komputer memilih: Gunting"
            3 -> textKomputer.text = "Komputer memilih: Kertas"
        }
    }
}
