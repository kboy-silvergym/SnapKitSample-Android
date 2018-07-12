package net.kboy.snapkitclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label: TextView = findViewById(R.id.textView)
        label.text = "Pemoji"

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            Toast.makeText(this, "タップされたよ！今度は画面遷移したいよ", Toast.LENGTH_SHORT).show()
        }
    }
}


