package net.kboy.snapkitclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.snapchat.kit.sdk.Bitmoji
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback

class BitmojiActivity : AppCompatActivity(), FetchAvatarUrlCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmoji)

        Bitmoji.fetchAvatarUrl(this, this)

    }

    // MARK: - FetchAvatarUrlCallback
    override fun onSuccess(p0: String?) {
        val imageView: ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(p0).into(imageView)
    }

    override fun onFailure(p0: Boolean, p1: Int) {

    }
}
