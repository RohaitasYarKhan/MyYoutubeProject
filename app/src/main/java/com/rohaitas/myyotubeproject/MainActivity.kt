package com.rohaitas.myyotubeproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohaitas.myyotubeproject.activities.ActivityCounter
import com.rohaitas.myyotubeproject.activities.ActivityRecyclerView
import com.rohaitas.myyotubeproject.activities.ActivityRoomDatabase
import com.rohaitas.myyotubeproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

/**************************** CODING BY ROHAITAS TANOLI ********************************************
 * =============================== ANDROID 2024 ====================================================
 * 1: Creating a button selector and change color
 *
 *
 */

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.btnCounterApp.setOnClickListener {
            startActivity(Intent(this, ActivityCounter::class.java))
        }


        binding.btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, ActivityRecyclerView::class.java))
        }
        binding.btnRoomDatabase.setOnClickListener {
            startActivity(Intent(this, ActivityRoomDatabase::class.java))
        }
    }

}










































