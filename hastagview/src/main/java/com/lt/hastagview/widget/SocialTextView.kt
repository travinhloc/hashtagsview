package com.lt.hastagview.widget

import android.R
import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.ColorInt
import com.lt.hastagview.widget.SocialView.OnChangedListener
import com.lt.hastagview.internal.SocialViewHelper
import java.util.regex.Pattern

/**
 * [android.widget.TextView] with hashtag, mention, and hyperlink support.
 *
 * @see SocialView
 */
class SocialTextView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.textViewStyle
) : AppCompatTextView(
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
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var isHyperlinkEnabled: Boolean
        get() = helper.isHyperlinkEnabled
        set(enabled) {
            helper.isHyperlinkEnabled = enabled
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var hashtagColors: ColorStateList
        get() = helper.hashtagColors
        set(colors) {
            helper.hashtagColors = colors
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var mentionColors: ColorStateList
        get() = helper.mentionColors
        set(colors) {
            helper.mentionColors = colors
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    override var hyperlinkColors: ColorStateList
        get() = helper.hyperlinkColors
        set(colors) {
            helper.hyperlinkColors = colors
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    @get:ColorInt
    override var hashtagColor: Int
        get() = helper.hashtagColor
        set(color) {
            helper.hashtagColor = color
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    @get:ColorInt
    override var mentionColor: Int
        get() = helper.mentionColor
        set(color) {
            helper.mentionColor = color
        }
    /**
     * {@inheritDoc}
     */
    /**
     * {@inheritDoc}
     */
    @get:ColorInt
    override var hyperlinkColor: Int
        get() = helper.hyperlinkColor
        set(color) {
            helper.hyperlinkColor = color
        }

    /**
     * {@inheritDoc}
     */
    override fun setOnHashtagClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnHashtagClickListener(listener)
    }

    /**
     * {@inheritDoc}
     */
    override fun setOnMentionClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnMentionClickListener(listener)
    }

    /**
     * {@inheritDoc}
     */
    override fun setOnHyperlinkClickListener(listener: SocialView.OnClickListener?) {
        helper.setOnHyperlinkClickListener(listener)
    }

    /**
     * {@inheritDoc}
     */
    override fun setHashtagTextChangedListener(listener: OnChangedListener?) {
        helper.setHashtagTextChangedListener(listener)
    }

    /**
     * {@inheritDoc}
     */
    override fun setMentionTextChangedListener(listener: OnChangedListener?) {
        helper.setMentionTextChangedListener(listener)
    }

    /**
     * {@inheritDoc}
     */
    override val hashtags: List<String?>
        get() = helper.hashtags

    /**
     * {@inheritDoc}
     */
    override val mentions: List<String?>
        get() = helper.mentions

    /**
     * {@inheritDoc}
     */
    override val hyperlinks: List<String?>
        get() = helper.hyperlinks

    init {
        helper = SocialViewHelper.install(this, attrs)
    }
}