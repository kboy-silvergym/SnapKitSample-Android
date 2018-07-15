package net.kboy.snapkitclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class LoginConfirmActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_confirm)

        val name = intent.extras.get("name")
        val avatar = intent.extras.get("avatar")

        val imageView: ImageView = findViewById(R.id.avatar)
        Glide.with(this).load(avatar.toString()).into(imageView)

        val nameLabel: TextView = findViewById(R.id.name)
        nameLabel.text = name.toString()

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "次に遷移するよ", Toast.LENGTH_SHORT).show()
        }
    }
}