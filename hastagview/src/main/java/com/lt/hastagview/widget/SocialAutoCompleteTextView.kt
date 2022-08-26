package com.lt.hastagview.widget

import android.content.Context

import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView
import android.widget.ArrayAdapter
import android.content.res.ColorStateList
import android.text.*
import androidx.annotation.ColorInt
import com.lt.hastagview.widget.SocialView.OnChangedListener
import android.util.AttributeSet
import androidx.appcompat.R
import com.lt.hastagview.internal.SocialViewHelper
import java.util.ArrayList
import java.util.regex.Pattern

/**
 * [android.widget.MultiAutoCompleteTextView] with hashtag, mention, and hyperlink support.
 *
 * @see SocialView
 */
class SocialAutoCompleteTextView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.autoCompleteTextViewStyle
) : AppCompatMultiAutoCompleteTextView(
    context!!, attrs, defStyleAttr
), SocialView {
    private val helper: SocialView

    // TODO: should check for symbols closest to cursor, not s[start]
    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (!TextUtils.isEmpty(s) && start < s.length) {
                when (s[start]) {
                    '#' -> if (adapter !== hashtagAdapter) {
                        setAdapter(hashtagAdapter)
                    }
                    '@' -> if (adapter !== mentionAdapter) {
                        setAdapter(mentionAdapter)
                    }
                }
            }
        }

        override fun afterTextChanged(s: Editable) {}
    }
    var hashtagAdapter: ArrayAdapter<*>? = null
    var mentionAdapter: ArrayAdapter<*>? = null
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
            setTokenizer(CharTokenizer())
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
            setTokenizer(CharTokenizer())
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

    /**
     * While `CommaTokenizer` tracks only comma symbol,
     * `CharTokenizer` can track multiple characters, in this instance, are hashtag and at symbol.
     *
     * @see CommaTokenizer
     */
    private inner class CharTokenizer internal constructor() : Tokenizer {
        private val chars: MutableCollection<Char> = ArrayList()
        override fun findTokenStart(text: CharSequence, cursor: Int): Int {
            var i = cursor
            while (i > 0 && !chars.contains(text[i - 1])) {
                i--
            }
            while (i < cursor && text[i] == ' ') {
                i++
            }

            // imperfect fix for dropdown still showing without symbol found
            if (i == 0 && isPopupShowing) {
                dismissDropDown()
            }
            return i
        }

        override fun findTokenEnd(text: CharSequence, cursor: Int): Int {
            var i = cursor
            val len = text.length
            while (i < len) {
                if (chars.contains(text[i])) {
                    return i
                } else {
                    i++
                }
            }
            return len
        }

        override fun terminateToken(text: CharSequence): CharSequence {
            var i = text.length
            while (i > 0 && text[i - 1] == ' ') {
                i--
            }
            return if (i > 0 && chars.contains(text[i - 1])) {
                text
            } else {
                if (text is Spanned) {
                    val sp: Spannable = SpannableString("$text ")
                    TextUtils.copySpansFrom(
                        text,
                        0,
                        text.length,
                        Any::class.java,
                        sp,
                        0
                    )
                    sp
                } else {
                    "$text "
                }
            }
        }

        init {
            if (isHashtagEnabled) {
                chars.add('#')
            }
            if (isMentionEnabled) {
                chars.add('@')
            }
        }
    }

    init {
        helper = SocialViewHelper.install(this, attrs)
        addTextChangedListener(textWatcher)
        setTokenizer(CharTokenizer())
    }
}