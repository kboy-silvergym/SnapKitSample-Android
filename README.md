# SnapKitSample-Android

This is an unofficial demo app of the Snap Kit produced by SnapChat.

## Login Kit
<img src="https://user-images.githubusercontent.com/17683316/42131965-12afd184-7d49-11e8-931b-0ef5578157df.png" width="100">

Following this document, you can implement SnapChat login. 
https://docs.snapchat.com/docs/login-kit/

You can fetch displayName & avatar (bitmoji avatar) so far.

<img src="https://user-images.githubusercontent.com/17683316/42731432-2a7035fc-8848-11e8-9581-a8e39f99b122.gif" width="250">

### 1.Call Login Method when the button tapped

```kotlin
val button: Button = findViewById(R.id.button2)
button.setOnClickListener {
    SnapLogin.getAuthTokenManager(this).startTokenGrant()
}
```

### 2.After login, fetch user datas

```kotlin
override fun onSuccess(p0: UserDataResponse?) {
    val me = p0!!.data.me
    val name = me.displayName
    val avatar = me.bitmojiData.avatar
    goToNextView(name, avatar)
}
```

## Creative Kit
<img src="https://user-images.githubusercontent.com/17683316/42131997-9b7b3b8e-7d49-11e8-9651-092cf14fed1e.png" width="100">

Following this document.
https://docs.snapchat.com/docs/creative-kit/ 


## Bitmoji Kit
<img src="https://user-images.githubusercontent.com/17683316/42131995-9914d864-7d49-11e8-95de-f8c053b2f706.png" width="100">

Following this document.
https://docs.snapchat.com/docs/creative-kit/

You can make a Bimoji avatar view & a Bitmoji selection picker.

<img src="https://user-images.githubusercontent.com/17683316/42732072-05064bbe-8855-11e8-9d8b-353e02b488a8.gif" width="250">

### Fetch avatar image

```kotlin
Bitmoji.fetchAvatarUrl(this, this)

// MARK: - FetchAvatarUrlCallback
override fun onSuccess(p0: String?) {
    currentImageURL = p0
    val imageView: ImageView = findViewById(R.id.imageView)
    Glide.with(this).load(p0).into(imageView)
}
```

### Show bitmoji pickerview

```kotlin
supportFragmentManager.beginTransaction()
    .replace(R.id.bitmoji_container, BitmojiFragment())
    .commit()
```
