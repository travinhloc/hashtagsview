package com.lt.hastagview.widget

/**
 * Simple optional mention data class, use when there is no custom mention class.
 */
class Mention @JvmOverloads constructor(
    /**
     * {@inheritDoc}
     */
    override val userName: CharSequence,
    /**
     * {@inheritDoc}
     */
    override val displayName: CharSequence? = null,
    /**
     * {@inheritDoc}
     */
    override val avatar: String? = ""
) : MentionAble {
    override fun equals(obj: Any?): Boolean {
        return obj is Mention && obj.userName === userName
    }

    override fun hashCode(): Int {
        return userName.hashCode()
    }

    override fun toString(): String {
        return userName.toString()
    }
}