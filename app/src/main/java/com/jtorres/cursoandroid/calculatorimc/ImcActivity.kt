package com.jtorres.cursoandroid.calculatorimc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jtorres.cursoandroid.R

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)

    }

    private fun initListeners() {
        viewMale.setOnClickListener { setGender(true) }
        viewFemale.setOnClickListener { setGender(false) }
    }

    private fun setGender(gender: Boolean) {
        val componentSelectedColor = ContextCompat.getColor(this, R.color.bg_component_selected)
        val componentColor = ContextCompat.getColor(this, R.color.bg_component)

        viewMale.setCardBackgroundColor(if (gender) componentSelectedColor else componentColor)
        viewFemale.setCardBackgroundColor(if (gender) componentColor else componentSelectedColor)
    }

}