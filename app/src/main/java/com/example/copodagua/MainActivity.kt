 package com.example.copodagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

 class MainActivity : AppCompatActivity() {

    private val prefs = GlassPreferences(this)
    var today: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_small).setOnClickListener {
            saveGlass(GlassType.SMALL)
        }
        findViewById<Button>(R.id.btn_medium).setOnClickListener {
            saveGlass(GlassType.MEDIUM)
        }
        findViewById<Button>(R.id.btn_larger).setOnClickListener {
            saveGlass(GlassType.LARGE)
        }

        refresh()
    }

    private fun saveGlass(glassType: GlassType) {
        prefs.save(today + glassType.value)
        Snackbar.make(findViewById(android.R.id.content), R.string.undo, Snackbar.LENGTH_LONG)
            .setAction(android.R.string.ok) {
                prefs.save(today - glassType.value)
                refresh()
            }
            .show()


        refresh()
    }
     private fun refresh() {
         val value = prefs.fetch()
         today = value
         findViewById<TextView>(R.id.txt_result).text = getString(R.string.result, today)
     }
}