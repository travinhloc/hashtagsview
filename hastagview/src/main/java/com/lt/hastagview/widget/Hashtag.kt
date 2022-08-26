package com.lt.hastagview.widget

class Hashtag @JvmOverloads constructor(
    /**
     * {@inheritDoc}
     */
    override val id: CharSequence,
    /**
     * {@inheritDoc}
     */
    override val count: Int = -1,
    /**
     * {@inheritDoc}
     */
) : HashtagAble {
    override fun equals(obj: Any?): Boolean {
        return obj is Hashtag && obj.id === id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return id.toString()
    }
}