package com.rohaitas.myyotubeproject.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohaitas.myyotubeproject.R
import com.rohaitas.myyotubeproject.adapter.AdapterRecyclerview
import com.rohaitas.myyotubeproject.databinding.ActivityRecyclerViewBinding

class ActivityRecyclerView : AppCompatActivity() {

    /**************************** CODING BY ROHAITAS TANOLI ********************************************
     * =============================== ANDROID 2024 ====================================================
     * 1: Creating a RecyclerView
     * 2: Changing Layout Manager at run time
     *
     *
     */

    lateinit var binding:ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // now recyclerview is setup
        initRv()

    }

    fun initRv(){
        val adapter = AdapterRecyclerview()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL ,
            false)

       // Let add data to Rv
        val list = ArrayList<String>()
        list.add("")
        list.add("")
        list.add("")
        list.add("")
        list.add("")

        list.addAll(list)
        list.addAll(list)
        list.addAll(list)
        list.addAll(list)
        list.addAll(list)

        // pass data to adapter

        adapter.setData(list)

        // now we need to change layout manager and viewType of rv

        var flag = false

        binding.imgChangeRv.setOnClickListener {
            flag = !flag
            adapter.flag = flag // change layout file
            if(flag){
                binding.rv.layoutManager = GridLayoutManager(it.context ,3)
                binding.imgChangeRv.setImageResource(R.drawable.button_list_view)

            }else{
                binding.imgChangeRv.setImageResource(R.drawable.button_grid_view)

                binding.rv.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL ,false)

            }

                // but some time there is a bug in some scenario
        }


    }



}