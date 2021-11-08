package com.rnc.ns.githubsearch.extension

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.rnc.ns.githubsearch.manager.ScoreManager

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(isGone: Boolean = true) {
    visibility = if(isGone) View.GONE else View.INVISIBLE
}

fun EditText.hideKeyboard() {
    ContextCompat.getSystemService(context, InputMethodManager::class.java)
        ?.hideSoftInputFromWindow(windowToken, 0)
}

fun TextView.string() = text.toString()

fun Int.toRating() = ScoreManager.getRating(this)