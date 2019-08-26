package com.example.thepremierleagueclubs.view.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.common.asynctaskcommon.bubbleSort
import kotlinx.android.synthetic.main.activity_complex_asyn_task_ops.*
import java.util.*

class ComplexAsynTaskOps : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complex_asyn_task_ops)


   //     var arr = intArrayOf(3, 60, 35, 2, 45, 320, 5)

        btn_get_numbers.setOnClickListener {

           // gets a List of Strings
            // the delimiter is comma followed by a whtitespace (", ")
            var arr = ed_enter_numbers.text.toString().split(", ")


            //this gives a List of Strings
            tv_display_unsorted.text = "" + arr

            //convert to IntArray from List of Strings
            var intArray: IntArray = IntArray(arr.size)
            var i = 0
            for(i in 0 until arr.size)
                intArray[i] = Integer.valueOf(arr.get(i))

            // works well with extension function
             tv_display_sorted.bubbleSort(intArray)

        }

        // works very well
       /* fun bubbleSort(arr: IntArray) : IntArray{

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
            return arr
        }

        tv_display.text =  Arrays.toString(bubbleSort(arr))
*/
    }
}
