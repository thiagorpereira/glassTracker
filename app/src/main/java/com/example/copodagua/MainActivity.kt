 package com.example.copodagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_small).setOnClickListenner {
            saveGlass(GlassType.SMALL)
        }
        findViewById<Button>(R.id.btn_medium).setOnClickListenner {
            saveGlass(GlassType.MEDIUM)
        }
        findViewById<Button>(R.id.btn_larger).setOnClickListenner {
            saveGlass(GlassType.LARGE)
        }
    }

    private fun saveGlass(glassType: GlassType) {

    }
}