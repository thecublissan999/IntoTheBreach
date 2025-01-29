package com.example.intothebreachmultimedia

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowMechasActivity: AppCompatActivity() {

    private var idx = 0


    private val mechaList = listOf(Mecha("No se x1",R.drawable.into_the_breach_img),
        Mecha("No se x2",R.drawable.into_the_breach_img),
        Mecha("No se x3",R.drawable.into_the_breach_img),
        Mecha("No se x4",R.drawable.into_the_breach_img),
        Mecha("No se x5",R.drawable.into_the_breach_img),
        Mecha("No se x6",R.drawable.into_the_breach_img))

    private val MINIMUN_LEGHT = 0
    private val MAXIMUN_LEGHT = mechaList.size - 1

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_mechas)
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        val rvMechas = findViewById<RecyclerView>(R.id.RVMechas)

        val cumbia = mutableListOf<Mecha>()
        cumbia.add(mechaList[MINIMUN_LEGHT])

        val adapter = setRecyclerView(rvMechas, cumbia)

        val btnRight = findViewById<ImageView>(R.id.BtnRight)
        val btnLeft = findViewById<ImageView>(R.id.BtnLeft)

        btnRight.setOnClickListener{
            if(MINIMUN_LEGHT != idx){
                idx--
            }else{
                idx = MAXIMUN_LEGHT
            }
            cumbia.clear()
            cumbia.add(mechaList[idx])
            adapter.notifyDataSetChanged()
        }

        btnLeft.setOnClickListener{
            if(MAXIMUN_LEGHT > idx){
                idx++
            }else{
                idx = MINIMUN_LEGHT
            }
            cumbia.clear()
            cumbia.add(mechaList[idx])
            adapter.notifyDataSetChanged()
        }
    }

    private fun setRecyclerView(rvMechas: RecyclerView,mechaList: List<Mecha>): MechasAdapter {
        val adapter = MechasAdapter(mechaList) { selectedMecha ->
            Toast.makeText(this, "Seleccionaste: ${selectedMecha.nameMecha}", Toast.LENGTH_SHORT).show()
        }
        rvMechas.layoutManager = GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false)
        rvMechas.adapter = adapter
        return adapter
    }


}