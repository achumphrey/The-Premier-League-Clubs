package com.example.thepremierleagueclubs.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.view.asynctask.ComplexAsynTaskOps
import com.example.thepremierleagueclubs.view.clubslistview.ClubListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

     override fun onClick(view: View) {

            when (view!!.id) {

                R.id.btn_get_prem -> {
                    intent = Intent(this, ClubListActivity::class.java)
                }

                R.id.btn_go_complex -> {
                    intent = Intent(this, ComplexAsynTaskOps::class.java)
                }
            }//END WHEN
            startActivity(intent)

        }//END ONCLICK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_prem.setOnClickListener(this)
        btn_go_complex.setOnClickListener(this)
    }
}
