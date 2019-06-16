package com.captain.ak.zomato.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.captain.ak.zomato.R

class SplashActivity : AppCompatActivity() {

    val DELAY: Long = 4000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        val handler = Handler()
        val runnable = Runnable {


            //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            //val animDrawable = splash_layout.background as AnimationDrawable

            //animDrawable.setEnterFadeDuration(10)
            //animDrawable.setExitFadeDuration(2000)
            //animDrawable.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, DELAY)


    }
}
