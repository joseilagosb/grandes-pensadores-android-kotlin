package com.example.grandespensadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private val SECTIONS = listOf<Section>(
    Section("default", "Con ustedes, Mike Wazowski", "", hasMultipleAuthors = false),
    Section("breaking_bad", "Frases de Breaking Bad", "", hasMultipleAuthors = true),
    Section("kanye_west", "The Kanye West Special", "", hasMultipleAuthors = false),
    Section("cheer_up", "Frases motivacionales", "", hasMultipleAuthors = true)
)

class CustomQuotesActivity : AppCompatActivity() {
    private var quotesFrom: String? = "default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_quotes)

        quotesFrom = intent.getStringExtra(EXTRA_QUOTES_FROM)
        println("Compilado de frases del gran $quotesFrom")
        val currentSection: Section? = SECTIONS.find{it.slug == quotesFrom}
        supportActionBar?.title = currentSection?.name

        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
}