package net.kboy.snapkitclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.snapchat.kit.sdk.SnapLogin
import com.snapchat.kit.sdk.core.controller.LoginStateController

class MainActivity : AppCompatActivity(), LoginStateController.OnLoginStateChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label: TextView = findViewById(R.id.textView)
        label.text = "Pemoji"

        SnapLogin.getLoginStateController(this).addOnLoginStateChangedListener(this)

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            SnapLogin.getAuthTokenManager(this).startTokenGrant()
        }

    }

    fun goToNextView() {
        val intent = Intent(this, LoginConfirmActivity::class.java)
        startActivity(intent)
    }

    // MARK : -  LoginStateController.OnLoginStateChangedListener

    override fun onLoginSucceeded() {
        print("login")
        goToNextView()
    }

    override fun onLoginFailed() {
        print("failed")
    }

    override fun onLogout() {
        print("onLogout")
    }
}


