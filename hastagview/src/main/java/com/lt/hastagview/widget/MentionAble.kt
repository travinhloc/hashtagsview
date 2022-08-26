package com.lt.hastagview.widget

/**
 * Abstract mention to be used with [com.lt.hastagview.widget.MentionArrayAdapter].
 */
interface MentionAble {
    /**
     * Unique id of this mention.
     */
    val userName: CharSequence

    /**
     * Optional display name, located above username.
     */
    val displayName: CharSequence?

    /**
     * Optional avatar, may be Drawable, resources, or string url pointing to image.
     */
    val avatar: String?
}