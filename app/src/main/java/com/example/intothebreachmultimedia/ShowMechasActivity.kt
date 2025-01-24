package com.example.intothebreachmultimedia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowMechasActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_mechas)
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        val rvMechas = findViewById<RecyclerView>(R.id.RVMechas)

        val mechaList = listOf(Mecha("No se x1",R.drawable.into_the_breach_img),
                                Mecha("No se x2",R.drawable.into_the_breach_img),
                                Mecha("No se x3",R.drawable.into_the_breach_img),
                                Mecha("No se x4",R.drawable.into_the_breach_img),
                                Mecha("No se x5",R.drawable.into_the_breach_img),
                                Mecha("No se x6",R.drawable.into_the_breach_img))



        val adapter = MechasAdapter(mechaList) { selectedMecha ->
            // Manejar clics en cada elemento
            Toast.makeText(this, "Seleccionaste: ${selectedMecha.nameMecha}", Toast.LENGTH_SHORT).show()
        }
        rvMechas.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvMechas.adapter = adapter
    }
}