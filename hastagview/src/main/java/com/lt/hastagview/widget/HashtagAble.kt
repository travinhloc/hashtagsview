package com.lt.hastagview.widget

/**
 * Abstract hashtag to be used with [com.lt.hastagview.widget.HashtagArrayAdapter].
 */
interface HashtagAble {
    /**
     * Unique id of this hashtag.
     */
    val id: CharSequence

    /**
     * Optional count, located right to hashtag name.
     */
    val count: Int
}