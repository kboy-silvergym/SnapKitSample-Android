package net.kboy.snapkitclient

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.snapchat.kit.sdk.SnapLogin
import com.snapchat.kit.sdk.SnapLogin.fetchUserData
import com.snapchat.kit.sdk.core.controller.LoginStateController
import com.snapchat.kit.sdk.core.models.UserDataResponse
import com.snapchat.kit.sdk.login.networking.FetchUserDataCallback

class MainActivity : AppCompatActivity(), LoginStateController.OnLoginStateChangedListener, FetchUserDataCallback {

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

    // MARK : -  LoginStateController.OnLoginStateChangedListener

    override fun onLoginSucceeded() {
        print("login")
        fetchUserData()
    }

    override fun onLoginFailed() {
        print("failed")
    }

    override fun onLogout() {
        print("onLogout")
    }

    // MARK : - FetchUserDataCallback

    override fun onSuccess(p0: UserDataResponse?) {
        val me = p0!!.data.me
        val name = me.displayName
        val avatar = me.bitmojiData.avatar

        // TODO: 画面遷移
        goToNextView(name, avatar)
    }

    override fun onFailure(p0: Boolean, p1: Int) {

    }

    private fun goToNextView(name: String, avatar: String) {
        val intent = Intent(this, LoginConfirmActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("avatar", avatar)
        startActivity(intent)
    }

    private fun fetchUserData() {
        val query = "{me{bitmoji{avatar},displayName}}"
        fetchUserData(this, query, null, this)
    }
}


