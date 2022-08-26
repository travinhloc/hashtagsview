package com.lt.hastagview.widget

import com.lt.hastagview.widget.Hashtagable
import com.lt.hastagview.widget.Hashtag

/**
 * Simple optional hashtag data class, use when there is no custom hashtag class.
 */
class Hashtag @JvmOverloads constructor(private val id: CharSequence, private val count: Int = -1) :
    Hashtagable {
    override fun equals(obj: Any?): Boolean {
        return obj is Hashtag && obj.id === id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return id.toString()
    }

    /**
     * {@inheritDoc}
     */
    override fun getId(): CharSequence {
        return id
    }

    /**
     * {@inheritDoc}
     */
    override fun getCount(): Int {
        return count
    }
}