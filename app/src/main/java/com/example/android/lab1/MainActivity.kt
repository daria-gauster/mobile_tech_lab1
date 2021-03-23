package com.example.android.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToAlarm.setOnClickListener {
            Intent(this, AlarmActivity::class.java).also{
                it.putExtra("EXTRA_NAME", getName())
                startActivity(it)
            }
        }

        btnToPhotoActivity.setOnClickListener {
            Intent(this, PhotoViewerActivity::class.java).also {
                it.putExtra("EXTRA_NAME", getName())
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    //create an action menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miContacts -> Toast.makeText(this, "contacts menu item", Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this, "favorites menu item", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> goToSettings()
            R.id.miClose -> finish()
            R.id.miFeedback -> Toast.makeText(this, "feedback", Toast.LENGTH_SHORT).show()

        }
        return true
    }

    //go to settings activity
    private fun goToSettings() {
        Intent(this, SettingsActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun getName() = etName.text.toString()
}