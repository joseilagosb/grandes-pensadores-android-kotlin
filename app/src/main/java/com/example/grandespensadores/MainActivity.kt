package com.example.grandespensadores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seeMoreButton = findViewById<Button>(R.id.see_more_button)
        val breakingBadQuotesButton = findViewById<CardView>(R.id.breaking_bad_quotes_button)
        val kanyeWestQuotesButton = findViewById<CardView>(R.id.kanye_west_quotes_button)
        val cheerUpQuotesButton = findViewById<CardView>(R.id.cheer_up_quotes_button)

        seeMoreButton.setOnClickListener {
            Toast.makeText(it.context, "Pagina en construccion, nos puedes contactar desde nuestra página oficial", Toast.LENGTH_LONG).show()
        }
        breakingBadQuotesButton.setOnClickListener {
            Toast.makeText(it.context, "Breaking bad frases", Toast.LENGTH_LONG).show()
        }
        kanyeWestQuotesButton.setOnClickListener {
            val intent = Intent(this, CustomQuotesActivity::class.java)
            startActivity(intent)
        }
        cheerUpQuotesButton.setOnClickListener {
            Toast.makeText(it.context, "Frases para alegrarte", Toast.LENGTH_LONG).show()
        }
    }
}