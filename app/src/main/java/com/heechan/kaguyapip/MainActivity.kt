package com.heechan.kaguyapip

import android.app.PictureInPictureParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private val mPipBuilder = PictureInPictureParams.Builder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.ima_main_kaguya)
        val btn = findViewById<Button>(R.id.btn_main_gotoPIP)

        Glide.with(this).load(R.raw.kaguya_animation).into(image)

        btn?.setOnClickListener {
            mPipBuilder.setAspectRatio(Rational(image.width, image.height))
            enterPictureInPictureMode(mPipBuilder.build())
        }
    }
}