package com.lt.hastagview.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatEditText
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.appcompat.R
import com.lt.hastagview.widget.SocialView.OnChangedListener
import com.lt.hastagview.internal.SocialViewHelper
import java.util.regex.Pattern

/**
 * [android.widget.EditText] with hashtag, mention, and hyperlink support.
 *
 * @see SocialView
 */
class SocialEditText @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.editTextStyle
) : AppCompatEditText(
    context!!, attrs, defStyleAttr
), SocialView {
    private val helper: SocialView
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var hashtagPattern: Pattern?
        get() = helper.hashtagPattern
        set(pattern) {
            helper.hashtagPattern = pattern
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var mentionPattern: Pattern?
        get() = helper.mentionPattern
        set(pattern) {
            helper.mentionPattern = pattern
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var hyperlinkPattern: Pattern?
        get() = helper.hyperlinkPattern
        set(pattern) {
            helper.hyperlinkPattern = pattern
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var isHashtagEnabled: Boolean
        get() = helper.isHashtagEnabled
        set(enabled) {
            helper.isHashtagEnabled = enabled
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var isMentionEnabled: Boolean
        get() = helper.isMentionEnabled
        set(enabled) {
            helper.isMentionEnabled = enabled
        }

    override var isHyperlinkEnabled: Boolean
        get() = helper.isHyperlinkEnabled
        set(enabled) {
            helper.isHyperlinkEnabled = enabled
        }

    override var hashtagColors: ColorStateList
        get() = helper.hashtagColors
        set(colors) {
            helper.hashtagColors = colors
        }

    override var mentionColors: ColorStateList
        get() = helper.mentionColors
        set(colors) {
            helper.mentionColors = colors
        }

    override var hyperlinkColors: ColorStateList
        get() = helper.hyperlinkColors
        set(colors) {
            helper.hyperlinkColors = colors
        }

    @get:ColorInt
    override var hashtagColor: Int
        get() = helper.hashtagColor
        set(color) {
            helper.hashtagColor = color
        }

    @get:ColorInt
    override var mentionColor: Int
        get() = helper.mentionColor
        set(color) {
            helper.mentionColor = color
        }

    @get:ColorInt
    override var hyperlinkColor: Int
        get() = helper.hyperlinkColor
        set(color) {
            helper.hyperlinkColor = color
        }

    override fun setOnHashtagClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnHashtagClickListener(listener)
    }

    override fun setOnMentionClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnMentionClickListener(listener)
    }

    override fun setOnHyperlinkClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnHyperlinkClickListener(listener)
    }

    override fun setHashtagTextChangedListener(listener: OnChangedListener?) {
        helper.setHashtagTextChangedListener(listener)
    }

    override fun setMentionTextChangedListener(listener: OnChangedListener?) {
        helper.setMentionTextChangedListener(listener)
    }

    override val hashtags: List<String?>
        get() = helper.hashtags

    override val mentions: List<String?>
        get() = helper.mentions

    override val hyperlinks: List<String?>
        get() = helper.hyperlinks

    init {
        helper = SocialViewHelper.install(this, attrs)
    }
}