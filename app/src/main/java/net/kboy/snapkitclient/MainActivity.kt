package net.kboy.snapkitclient

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.snapchat.kit.sdk.SnapLogin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label: TextView = findViewById(R.id.textView)
        label.text = "Pemoji"

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            //val intent = Intent(this, LoginConfirmActivity::class.java)
            //startActivity(intent)

            SnapLogin.getAuthTokenManager(this).startTokenGrant()
        }
    }
}


