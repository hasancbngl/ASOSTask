package com.adrianczuczka.asostask.util

import android.view.View

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