package com.example.grandespensadores

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.grandespensadores.api.KanyeWestAPIClient
import kotlin.concurrent.thread

private val SECTIONS = listOf<Section>(
    Section("default", "Con ustedes, Mike Wazowski", "", hasMultipleAuthors = false),
    Section("breaking_bad", "Frases de Breaking Bad", "", hasMultipleAuthors = true),
    Section("kanye_west", "The Kanye West Special", "", hasMultipleAuthors = false),
    Section("cheer_up", "Frases motivacionales", "", hasMultipleAuthors = true)
)

class CustomQuotesActivity : AppCompatActivity() {
    private var quotesFrom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_quotes)

        quotesFrom = intent.getStringExtra(EXTRA_QUOTES_FROM)

        // Buscamos en el arreglo de SECTIONS el identificador de la section que acabamos de abrir
        val currentSection: Section = SECTIONS.find{it.slug == quotesFrom} ?: SECTIONS[0]

        // Modificamos el titulo de la barra superior
        supportActionBar?.title = currentSection.name
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#cb2cf2")))

        // Modificamos el texto de nuestro quote
        val quoteBodyText = findViewById<TextView>(R.id.quote_body_text)
        val quoteAuthorText = findViewById<TextView>(R.id.quote_author_text)
        quoteBodyText.text = "A medida que uno va ganando cosas se hamburguesa."
        quoteAuthorText.text = "-Carlos Tévez"

        // Modificamos el fondo de la carta contenedora de la frase
        val quoteCardImage = findViewById<ImageView>(R.id.quote_card_image)
        quoteCardImage.setImageResource(when(currentSection.slug) {
            "breaking_bad" -> R.drawable.breaking_bad_quotes_background
            "kanye_west" -> R.drawable.kanye_west_quotes_background
            "cheer_up" -> R.drawable.cheer_up_quotes_background
            else -> R.drawable.default_quotes_background
        })

        // Ocultamos el nombre del autor si la sección es de solo un autor
        if (!currentSection.hasMultipleAuthors) {
            quoteAuthorText.isVisible = false
        }

        var currentQuote: Quote? = null

        thread {
            val quote = KanyeWestAPIClient.service.getQuote()
            val body = quote.execute().body()

            if (body != null) {
                currentQuote = Quote(body.quote, "Kanye West")
                Log.d("CustomQuotesActivity", body.quote)

                this@CustomQuotesActivity.runOnUiThread(java.lang.Runnable {
                    quoteBodyText.text = currentQuote?.body
                })
            }
        }
    }
}