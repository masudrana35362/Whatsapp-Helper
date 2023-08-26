package com.masud.whatsappsmessage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.masud.whatsappsmessage.databinding.ActivityMainBinding
import com.masud.whatsappsmessage.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.txtVersion.text= "Version ${BuildConfig.VERSION_NAME}"

        val rightSlide = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        val leftSlide = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        binding.imageCard.startAnimation(rightSlide)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }
}