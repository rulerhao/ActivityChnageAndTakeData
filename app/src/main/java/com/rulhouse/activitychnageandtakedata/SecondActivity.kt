package com.rulhouse.activitychnageandtakedata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    lateinit var backToFirstActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        backToFirstActivity = findViewById(R.id.back_to_first)
        backToFirstActivity.setOnClickListener {
            val data = Intent()
            data.putExtra(ActivityKey.returnKey,"result value");
            setResult(RESULT_OK, data);
            finish()
        }
    }
}