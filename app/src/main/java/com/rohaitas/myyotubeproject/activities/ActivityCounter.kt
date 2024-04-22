package com.rohaitas.myyotubeproject.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohaitas.myyotubeproject.R
import com.rohaitas.myyotubeproject.databinding.ActivityCounterBinding

class ActivityCounter : AppCompatActivity() {


    /**************************** CODING BY ROHAITAS TANOLI ********************************************
     * =============================== ANDROID 2024 ====================================================
     * We are simply creating a counterApp Later, we will add more feature to App in upcoming videos
     * I will keep videos short and easy To Understand
     * You will learn Basics of
    - viewBinding
    - Object class
    - Observing with Live Data
    - Updating live data using Mutable live data

     */

    lateinit var binding : ActivityCounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // this is bad not forever
//        FontSize.data.observeForever(){
//            binding.btnCounter.text = "$it"
//        }

        // this observe for activity/fragment is in foreground
        FontSize.data.observe(this){
            binding.btnCounter.text = "$it"
        }

        // now lets change value

        var counter = 1
        binding.btnCounter.setOnClickListener {
            FontSize.updateData(counter++)
            // done its working. It will work for all activities we only need to observe it
        }


        /*************** LET START
         *  1 : Enable ViewBinding
         *  2 : Creating an object class, singleton, used from anywhere to store integer
         *  3 : Now observer the changes in Object class
         *
         * **/
    }
}

object FontSize {
    private val _value = MutableLiveData(1)  // defining integer with default value

    val data: LiveData<Int>    // getting value fun
        get() = _value

    fun updateData(data: Int) {    // for update
        _value.value = data
    }
}

// Benefit is to use anywhere in app. when i value change it reflect on all activities and fragments


