package com.lt.hastagview.widget

/**
 * Abstract mention to be used with [com.lt.hastagview.widget.MentionArrayAdapter].
 */
interface Mentionable {
    /**
     * Unique id of this mention.
     */
    val username: CharSequence

    /**
     * Optional display name, located above username.
     */
    val displayname: CharSequence?

    /**
     * Optional avatar, may be Drawable, resources, or string url pointing to image.
     */
    val avatar: Any?
}