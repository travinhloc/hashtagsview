package com.lt.hastagview.widget

class Hashtag(id: CharSequence, count: Int = -1): HashtagAble {
    override val id: CharSequence
        get() = this.id
    override val count: Int
        get() =this.count

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