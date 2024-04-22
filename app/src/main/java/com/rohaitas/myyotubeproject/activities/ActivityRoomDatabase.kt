package com.rohaitas.myyotubeproject.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohaitas.myyotubeproject.adapter.AdapterUsers
import com.rohaitas.myyotubeproject.database.AppDatabase
import com.rohaitas.myyotubeproject.database.User
import com.rohaitas.myyotubeproject.databinding.ActivityRoomDatabaseBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityRoomDatabase : AppCompatActivity() {

    /**************************** CODING BY ROHAITAS TANOLI ********************************************
     * =============================== ANDROID 2024 ====================================================
     * ====> ROOM DATABASE
     * We will Create table Name Users
     * - Add User
     * - Delete User
     * - update User
     * Observing Changes using LiveData
     * */

    lateinit var binding : ActivityRoomDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRoomDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


            initRv()

            insertUser()

            getData()




         // So everything is now Working.
        // Lets observe the data
        // Now Add value to db

        // IT is working: Room Insertion and observing throught live data is finish
        // Thanks For watching the video.
        // i made some mistake. So that you can learn easily.

        val handler = Handler(Looper.getMainLooper())
        val runnable = object  : Runnable {
            override fun run() {
                insertUser()
                // strange this is not working in kotlin
                handler.postDelayed(this,1000)
            }


        }

        handler.postDelayed(runnable,1000)

    }

    fun insertUser(){
        val name = "Rohaitas"

        CoroutineScope(IO).launch {
            val user = User(0, name) // id doesn't matter it will auto generate
            AppDatabase.instance!!.userDao().insertUsers(user)
        }
    }

    fun getData(){

        // in background thread

        CoroutineScope(IO).launch {
            val list = AppDatabase.instance!!.userDao().getAllUsers()

             // Live data can be observed but in main

            // now in main thread
            withContext(Dispatchers.Main){



                list.observe(this@ActivityRoomDatabase){
                    adapter.setData(it)
                }

            }  // fetching of data is completed
        }
    }

    lateinit var adapter :AdapterUsers

    private fun initRv() {
          adapter = AdapterUsers()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.VERTICAL,
            false
        )
    }
}