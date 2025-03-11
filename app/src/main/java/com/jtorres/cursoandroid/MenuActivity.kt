package com.jtorres.cursoandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludar = findViewById<Button>(R.id.btnSaludarApp)
        btnSaludar.setOnClickListener { navigateTo("Saludar") }
        val btnImc = findViewById<Button>(R.id.btnImcApp)
        btnImc.setOnClickListener { navigateTo("IMC") }
    }

    private fun navigateTo(s: String) {
        val intent = when (s) {
            "Saludar" -> Intent(this, firstApp.FirstAppActivity::class.java)
            "IMC" -> Intent(this, com.jtorres.cursoandroid.calculatorimc.ImcActivity::class.java )
            else -> null
        }
        intent?.let { startActivity(it) }
    }
}
