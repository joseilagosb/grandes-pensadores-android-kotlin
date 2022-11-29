package com.example.grandespensadores

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

public const val EXTRA_QUOTES_FROM: String = "com.example.grandespensadores.extra_quotes_from"

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
            startActivity(newQuotesActivityIntent(this, "breaking_bad"))
        }
        kanyeWestQuotesButton.setOnClickListener {
            startActivity(newQuotesActivityIntent(this, "kanye_west"))
        }
        cheerUpQuotesButton.setOnClickListener {
            startActivity(newQuotesActivityIntent(this, "cheer_up"))
        }
    }

    companion object {
        fun newQuotesActivityIntent(packageContext: Context, quotes_from: String): Intent {
            return Intent(packageContext, CustomQuotesActivity::class.java).apply {
                putExtra(EXTRA_QUOTES_FROM, quotes_from)
            }
        }
    }
}