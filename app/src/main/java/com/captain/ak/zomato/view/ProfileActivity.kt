package com.captain.ak.zomato.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.captain.ak.zomato.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        window.statusBarColor = resources.getColor(R.color.white)

        back.setOnClickListener { onBackPressed() }
    }
}
