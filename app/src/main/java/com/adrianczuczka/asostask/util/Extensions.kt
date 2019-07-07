package com.adrianczuczka.asostask.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

infix fun <T : View> T.makeVisibleAndApply(function: T.() -> Unit) {
    visible()
    function()
}

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)