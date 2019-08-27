package com.example.thepremierleagueclubs.common.clubdetailcommon

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView

fun TextView.changeTextColour(originalText: String) {

    val spannableString: SpannableString = SpannableString(originalText)
    val foregroundColorSpan: ForegroundColorSpan = ForegroundColorSpan(Color.BLUE)

    spannableString.setSpan(
        foregroundColorSpan,
        0,
        originalText.length,
        Spanned.SPAN_INCLUSIVE_INCLUSIVE
    )

    this.text = spannableString
}

fun TextView.changeBackgroudColour(originalText: String) {

    val spannableString: SpannableString = SpannableString(originalText)
    val backgroundColorSpan: BackgroundColorSpan = BackgroundColorSpan(Color.YELLOW)

    spannableString.setSpan(
        backgroundColorSpan,
        0,
        originalText.length,
        Spanned.SPAN_INCLUSIVE_INCLUSIVE
    )

    this.text = spannableString
}

fun TextView.changeTextStyle(originalText: String) {

    val spannableString: SpannableString = SpannableString(originalText)
    spannableString.setSpan(
        StyleSpan(Typeface.BOLD_ITALIC),
        0,
        originalText.length,
        Spanned.SPAN_INCLUSIVE_INCLUSIVE
    )
    this.text = spannableString
}

fun TextView.changeTextColourGreen(originalText: String) {

    val spannableString: SpannableString = SpannableString(originalText)
    val foregroundColorSpan: ForegroundColorSpan = ForegroundColorSpan(Color.GREEN)

    spannableString.setSpan(
        foregroundColorSpan,
        0,
        originalText.length,
        Spanned.SPAN_INCLUSIVE_INCLUSIVE
    )

    this.text = spannableString
}

fun TextView.changeBackgroudColourGray(originalText: String) {

    val spannableString: SpannableString = SpannableString(originalText)
    val backgroundColorSpan: BackgroundColorSpan = BackgroundColorSpan(Color.GRAY)

    spannableString.setSpan(
        backgroundColorSpan,
        0,
        originalText.length,
        Spanned.SPAN_INCLUSIVE_INCLUSIVE
    )

    this.text = spannableString
}
