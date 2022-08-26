package com.lt.hastagview.widget

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import com.lt.hastagview.widget.SocialView.OnChangedListener
import com.lt.hastagview.widget.SocialView
import java.util.regex.Pattern

/**
 * Base interface of all social widgets, which usually derived from [TextView].
 * Out of the box, there are [SocialTextView], [SocialEditText], and `SocialAutoCompleteTextView`.
 * It can also be implemented in any [android.view.View]
 * using [SocialViewHelper].
 */
interface SocialView {
    /**
     * Returns regex that are responsible for finding **hashtags**.
     * By default, the pattern are `#(\w+)`.
     */
    /**
     * Modify regex that are responsible for finding **hashtags**.
     *
     * @param pattern custom regex. When null, default pattern will be used.
     */
    var hashtagPattern: Pattern?
    /**
     * Returns regex that are responsible for finding **mentions**.
     * By default, the pattern are `@(\w+)`.
     */
    /**
     * Modify regex that are responsible for finding **hashtags**.
     *
     * @param pattern custom regex. When null, default pattern will be used.
     */
    var mentionPattern: Pattern?
    /**
     * Returns regex that are responsible for finding **hyperlinks**.
     * By default, the pattern are [PatternsCompat.WEB_URL].
     */
    /**
     * Modify regex that are responsible for finding **hashtags**.
     *
     * @param pattern custom regex. When null, default pattern will be used.
     */
    var hyperlinkPattern: Pattern?
    /**
     * Returns true if **hashtags** in this view are spanned.
     */
    /**
     * Determine whether this view should span **hashtags**.
     *
     * @param enabled True when spanning should be enabled.
     */
    var isHashtagEnabled: Boolean
    /**
     * Returns true if **mentions** in this view are spanned.
     */
    /**
     * Determine whether this view should span **mentions**.
     *
     * @param enabled True when spanning should be enabled.
     */
    var isMentionEnabled: Boolean
    /**
     * Returns true if **hyperlinks** in this view are spanned.
     */
    /**
     * Determine whether this view should span **hyperlinks**.
     *
     * @param enabled True when spanning should be enabled.
     */
    var isHyperlinkEnabled: Boolean
    /**
     * Returns color instance of **hashtags**, default is color accent of current app theme.
     * Will still return corresponding color even when [.isHashtagEnabled] is false.
     */
    /**
     * Sets **hashtags** color instance.
     *
     * @param colors Colors state list instance.
     */
    var hashtagColors: ColorStateList
    /**
     * Returns color instance of **mentions**, default is color accent of current app theme.
     * Will still return corresponding color even when [.isMentionEnabled] ()} is false.
     */
    /**
     * Sets **mentions** color instance.
     *
     * @param colors Colors state list instance.
     */
    var mentionColors: ColorStateList
    /**
     * Returns color instance of **hyperlinks**, default is color accent of current app theme.
     * Will still return corresponding color even when [.isHyperlinkEnabled] ()} is false.
     */
    /**
     * Sets **hyperlinks** color instance.
     *
     * @param colors Colors state list instance.
     */
    var hyperlinkColors: ColorStateList
    /**
     * Returns color integer of **hashtags**.
     *
     * @see .getHashtagColors
     */
    /**
     * Sets **hashtags** color integer.
     *
     * @param color Color integer.
     * @see .setHashtagColors
     */
    @get:ColorInt
    var hashtagColor: Int
    /**
     * Returns color integer of **mentions**.
     *
     * @see .getMentionColors
     */
    /**
     * Sets **mentions** color integer.
     *
     * @param color Color integer.
     * @see .setMentionColors
     */
    @get:ColorInt
    var mentionColor: Int
    /**
     * Returns color integer of **hyperlinks**.
     *
     * @see .getHyperlinkColors
     */
    /**
     * Sets **hyperlinks** color integer.
     *
     * @param color Color integer.
     * @see .setHyperlinkColors
     */
    @get:ColorInt
    var hyperlinkColor: Int

    /**
     * Registers a callback to be invoked when a **hashtag** is clicked.
     *
     * @param listener The callback that will run.
     */
    fun setOnHashtagClickListener(listener: OnClickListener?)

    /**
     * Registers a callback to be invoked when a **mention** is clicked.
     *
     * @param listener The callback that will run.
     */
    fun setOnMentionClickListener(listener: OnClickListener?)

    /**
     * Registers a callback to be invoked when a **hyperlink** is clicked.
     *
     * @param listener The callback that will run.
     */
    fun setOnHyperlinkClickListener(listener: OnClickListener?)

    /**
     * Registers a text watcher to be invoked when a **hashtag** is modified.
     *
     * @param listener The callback that will run.
     */
    fun setHashtagTextChangedListener(listener: OnChangedListener?)

    /**
     * Registers a text watcher to be invoked when a **mention** is modified.
     *
     * @param listener The callback that will run.
     */
    fun setMentionTextChangedListener(listener: OnChangedListener?)

    /**
     * Returns list of all **hashtags** found in [TextView.getText].
     */
    val hashtags: List<String?>

    /**
     * Returns list of all **mentions** found in [TextView.getText].
     */
    val mentions: List<String?>

    /**
     * Returns list of all **hyperlinks** found in [TextView.getText].
     */
    val hyperlinks: List<String?>

    /**
     * Interface definition for a callback to be invoked when a **hashtag**,
     * **mention**, or **hyperlink** is clicked.
     */
    interface OnClickListener {
        /**
         * Called when a text has been clicked.
         *
         * @param view The view that the texts belong to.
         * @param text The text that was clicked.
         */
        fun onClick(view: SocialView, text: CharSequence)
    }

    /**
     * Interface definition for a callback to be invoked when a **hashtag**,
     * **mention**, or **hyperlink** is modified.
     */
    interface OnChangedListener {
        /**
         * Called when a text has been modified.
         *
         * @param view The view that the texts belong to.
         * @param text The text that was modified.
         */
        fun onChanged(view: SocialView, text: CharSequence)
    }
}