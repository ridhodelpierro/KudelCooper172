package com.example.kudelcooper17

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_game.*
import java.util.logging.Handler
import kotlin.random.Random

private const val Batu = 1
private const val Gunting = 2
private const val Kertas = 3


class GameActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "username"
    }

    var username:String = ""
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        username = intent.getStringExtra("EXTRA_USER")

        var pilihankomputer:Int
        var pilihanplayer:Int

        buttonBatu.setOnClickListener {
            textPlayer.text = "BATU"
                pilihanplayer = Batu
            pilihankomputer = getpilihanKomputer()
            textPlayer.text = ""
            android.os.Handler().postDelayed({
                textHasil.text = suwit(pilihanplayer,pilihankomputer)
                showpilihankomputer(pilihankomputer)
            },1500)
        }
        buttonGunting.setOnClickListener {
            textPlayer.text = "GUNTING"
            pilihanplayer = Gunting
            pilihankomputer = getpilihanKomputer()
            textPlayer.text = ""
            android.os.Handler().postDelayed({
                textHasil.text = suwit(pilihanplayer,pilihankomputer)
                showpilihankomputer(pilihankomputer)
            },1500)
        }
        buttonKertas.setOnClickListener {
            textPlayer.text = "KERTAS"
                pilihanplayer = Kertas
            pilihankomputer = getpilihanKomputer()
            textPlayer.text = ""
            android.os.Handler().postDelayed({
                textHasil.text = suwit(pilihanplayer,pilihankomputer)
                showpilihankomputer(pilihankomputer)
            },1500)
        }

    }

    fun getpilihanKomputer():Int{
        return java.util.Random().nextInt(3) + 1;
    }

    fun suwit(pilihanplayer:Int,pilihankomputer:Int):String{
        var hasil: String= ""
        if(pilihanplayer == pilihankomputer){
            hasil = "KALIAN IMBANG"
            textHasil.setTextColor(Color.YELLOW)
        }
        else if((pilihanplayer == Batu && pilihankomputer == Kertas) ||
                (pilihanplayer == Gunting && pilihankomputer == Batu) ||
                (pilihanplayer == Kertas && pilihankomputer == Gunting)){
            hasil = username + " KALAH"
            textHasil.setTextColor(Color.RED)
        }
        else{
            hasil = username + " MENANG"
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

private fun Handler.postDelayed(function: () -> Unit) {

}
