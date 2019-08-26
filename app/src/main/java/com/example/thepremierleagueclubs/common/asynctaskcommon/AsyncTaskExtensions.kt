package com.example.thepremierleagueclubs.common.asynctaskcommon

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import java.util.*

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

fun runCode(arr: IntArray){
    for (a in arr )
        print("$a, " )
}

fun TextView.bubbleSort(arr: IntArray){

        var n: Int = arr.size;
        var temp = 0
        var i = 0
        var k = 1
        for (r in i until n){

            for (j in k until n){

                if (arr[j-1] > arr[j]) {
                    //swap elements
                    temp = arr[j-1]
                    arr[j-1] = arr[j]
                    arr[j] = temp
                }
            }
        }
   this.text = Arrays.toString(arr)
}

