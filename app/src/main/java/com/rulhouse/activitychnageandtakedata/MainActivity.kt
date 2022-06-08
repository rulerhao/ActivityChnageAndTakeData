package com.rulhouse.activitychnageandtakedata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val returnKey = "dataKey"

    lateinit var goToSecondActivityButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToSecondActivityButton = findViewById(R.id.go_to_second)
        goToSecondActivityButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            toSecondActivity.launch(intent)
        }
    }

    private val toSecondActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                val value = data?.getStringExtra(ActivityKey.returnKey)
                if (value != null) {
                    Log.d("GG", value)
                }
            }
        }
}