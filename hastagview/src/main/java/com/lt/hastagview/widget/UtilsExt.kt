package com.lt.hastagview.widget

import android.annotation.SuppressLint
import android.widget.TextView
import com.lt.hastagview.R

@SuppressLint("SetTextI18n")
fun setTextHashTagsPostsCount(textView: TextView, number: Int) {
    textView.text = if (number <= 0) {
        textView.context.getString(R.string.many_posts, 0)
    } else if (number >= 100000) {
        textView.context.getString(R.string.million_posts, (number / 100000))
    } else if (number > 1000) {
        textView.context.getString(R.string.thousand_posts, (number / 1000))
    } else if (number == 1) {
        textView.context.getString(R.string.one_post)
    } else {
        textView.context.getString(R.string.many_posts, number)
    }
}
