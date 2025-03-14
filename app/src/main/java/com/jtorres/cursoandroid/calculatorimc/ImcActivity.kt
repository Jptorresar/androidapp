package com.jtorres.cursoandroid.calculatorimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider
import com.jtorres.cursoandroid.R
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider


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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

    }

    private fun initListeners() {
        viewMale.setOnClickListener { setGender(true) }
        viewFemale.setOnClickListener { setGender(false) }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result CM"
        }
    }

    private fun setGender(gender: Boolean) {
        val componentSelectedColor = ContextCompat.getColor(this, R.color.bg_component_selected)
        val componentColor = ContextCompat.getColor(this, R.color.bg_component)

        viewMale.setCardBackgroundColor(if (gender) componentSelectedColor else componentColor)
        viewFemale.setCardBackgroundColor(if (gender) componentColor else componentSelectedColor)
    }

}