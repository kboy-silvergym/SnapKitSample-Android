package net.kboy.snapkitclient

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.snapchat.kit.sdk.Bitmoji
import com.snapchat.kit.sdk.SnapCreative
import com.snapchat.kit.sdk.bitmoji.OnBitmojiSelectedListener
import com.snapchat.kit.sdk.bitmoji.networking.FetchAvatarUrlCallback
import com.snapchat.kit.sdk.bitmoji.ui.BitmojiFragment
import com.snapchat.kit.sdk.creative.models.SnapPhotoContent
import java.io.File

class BitmojiActivity : AppCompatActivity(), FetchAvatarUrlCallback, OnBitmojiSelectedListener {

    var currentImageURL: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmoji)

        Bitmoji.fetchAvatarUrl(this, this)

        supportFragmentManager.beginTransaction()
                .replace(R.id.bitmoji_container, BitmojiFragment())
                .commit()

        val bitmojiImageView: ImageView = findViewById(R.id.imageView2)
        bitmojiImageView.setOnClickListener {
            sendSnapchat(currentImageURL!!)
        }
    }

    private fun sendSnapchat(path: String){
        val snapCreativeKitApi = SnapCreative.getApi(this)
        val snapMediaFactory = SnapCreative.getMediaFactory(this)
        val file: File = File(filesDir, "my_files")
        file.mkdir()
        val output = File(file, "title")
        val photoFile = snapMediaFactory.getSnapPhotoFromFile(output)
        val snapPhotoContent = SnapPhotoContent(photoFile)
        snapCreativeKitApi.send(snapPhotoContent)
    }


    // MARK: - FetchAvatarUrlCallback
    override fun onSuccess(p0: String?) {
        currentImageURL = p0
        val imageView: ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(p0).into(imageView)
    }

    override fun onFailure(p0: Boolean, p1: Int) {

    }

    // MARK: - OnBitmojiSelectedListener

    override fun onBitmojiSelected(p0: String?) {
        val bitmojiImageView: ImageView = findViewById(R.id.imageView2)
        Glide.with(this).load(p0).into(bitmojiImageView)
    }
}
