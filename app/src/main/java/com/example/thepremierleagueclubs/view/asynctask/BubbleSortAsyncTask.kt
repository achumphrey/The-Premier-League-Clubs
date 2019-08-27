package com.example.thepremierleagueclubs.view.asynctask

import android.os.AsyncTask
import java.util.*


class BubbleSortArray : AsyncTask<IntArray, Void, IntArray>() {

    override fun doInBackground(vararg arr: IntArray): IntArray {

        var n: Int = arr.size;
        var temp = 0
        var i = 0
        var k = 1
        for (r in i until n){

            for (j in k until n){

                if (arr[j-1] as Int > arr[j] as Int) {
                    //swap elements
                    temp = arr[j-1] as Int
                    arr[j-1] = arr[j] as Nothing
                    arr[j] = temp as Nothing
                }
            }
        }
        return arr as IntArray
    }

    override fun onPostExecute(result: IntArray?) {
        super.onPostExecute(result)

   //     tv_display_sorted.text =  Arrays.toString(result)
    }
}
