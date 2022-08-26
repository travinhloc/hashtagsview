package com.lt.hastagview.widget

/**
 * Simple optional mention data class, use when there is no custom mention class.
 */
class Mention @JvmOverloads constructor(
    /**
     * {@inheritDoc}
     */
    override val username: CharSequence,
    /**
     * {@inheritDoc}
     */
    override val displayname: CharSequence? = null,
    /**
     * {@inheritDoc}
     */
    override val avatar: Any? = null
) : MentionAble {
    override fun equals(obj: Any?): Boolean {
        return obj is Mention && obj.username === username
    }

    override fun hashCode(): Int {
        return username.hashCode()
    }

    override fun toString(): String {
        return username.toString()
    }
}