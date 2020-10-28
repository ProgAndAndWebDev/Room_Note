package com.gamdestroyerr.roomnote.utils

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.widget.ImageView
import androidx.core.app.ActivityCompat.postponeEnterTransition
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gamdestroyerr.roomnote.ui.activity.NoteActivity


fun View.hideKeyboard() =
    (context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(windowToken, HIDE_NOT_ALWAYS)

fun Context.loadImage(
    uri: Uri?,
    image: ImageView
) {
    postponeEnterTransition(NoteActivity())
    Glide.with(this)
        .load(uri)
        .override(2000, 2000)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .thumbnail(0.01f)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .into(image)
}

fun Context.loadHiRezThumbnail(
    uri: Uri?,
    image: ImageView
) = Glide.with(this)
    .load(uri)
    .override(500, 600)
    .diskCacheStrategy(DiskCacheStrategy.DATA)
    .thumbnail(0.1f)
    .transition(DrawableTransitionOptions.withCrossFade(200))
    .into(image)
