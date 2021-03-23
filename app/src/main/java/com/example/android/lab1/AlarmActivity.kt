package com.example.android.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val name = intent.getStringExtra("EXTRA_NAME")
        tvAlarm.text = "$name, click the button!"

        val alertDial = AlertDialog.Builder(this)
            .setTitle("alert dialog!")
            .setPositiveButton("yes") { _, _ ->
                Toast.makeText(this, "you clicked yes", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("no") { _, _ ->
                Toast.makeText(this, "you clicked no", Toast.LENGTH_SHORT).show()
            }.create()

        btnAlarm.setOnClickListener {
            alertDial.show()
        }
    }
}