package com.example.intothebreachmultimedia

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MechaAnimation: AppCompatActivity() {

    private var videoVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.mecha_animation)
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        val mechaText = findViewById<TextView>(R.id.textMecha)
        val mechaImage = findViewById<ImageView>(R.id.imageMecha)
        val mechaVideoContainer = findViewById<FrameLayout>(R.id.mechaVideoContainer)
        val mechaVideo = findViewById<VideoView>(R.id.videoMecha)

        // Animación inicial para la imagen y el texto
        mechaImage.scaleX = 0f
        mechaImage.scaleY = 0f
        mechaText.alpha = 0f

        mechaImage.animate().scaleX(1f).scaleY(1f).setDuration(800).start()
        mechaText.visibility = View.VISIBLE
        mechaText.animate().alpha(1f).setDuration(800).start()

        // Ocultar el video al hacer clic en el fondo
        mechaVideoContainer.setOnClickListener {
            hideVideo(mechaVideoContainer)
            videoVisible = false
        }
    }

    private fun showVideo(videoContainer: View, videoView: VideoView) {
        val videoPath = "android.resource://$packageName/raw/video_sample"
        videoView.setVideoURI(Uri.parse(videoPath))

        // Mostrar el video con animación
        videoContainer.visibility = View.VISIBLE
        videoContainer.alpha = 0f
        videoContainer.scaleX = 0.8f
        videoContainer.scaleY = 0.8f

        videoContainer.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(500)
            .start()

        videoView.start()
    }

    private fun hideVideo(videoContainer: View) {
        videoContainer.animate()
            .alpha(0f)
            .scaleX(0.8f)
            .scaleY(0.8f)
            .setDuration(300)
            .withEndAction {
                videoContainer.visibility = View.GONE
            }
            .start()
    }
}