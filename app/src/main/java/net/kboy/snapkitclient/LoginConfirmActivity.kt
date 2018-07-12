package net.kboy.snapkitclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class LoginConfirmActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_confirm)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "カメラに遷移するよ", Toast.LENGTH_SHORT).show()
        }
    }
}