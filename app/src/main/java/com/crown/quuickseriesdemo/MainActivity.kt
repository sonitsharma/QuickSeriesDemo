package com.crown.quuickseriesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.crown.quuickseriesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extras = intent.extras
        val payloadData1 = extras?.get("Company")
        val payloadData2 = extras?.get("Position")
        val payloadData3 = extras?.get("Image")
        val payloadData4 = extras?.get("URI")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickevents()
        if(extras?.get("Company")!=null)
        binding.textView.text = payloadData1.toString()+ payloadData2.toString()

        binding.textView2.text  = if(payloadData3!=null) payloadData1.toString()+ payloadData2.toString() else ""

    if(payloadData3!=null)
        {
            Glide
                .with(this)
                .load(payloadData3)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.imageView)
        }


        if(payloadData4.toString().contains("Details"))
        {
            val   intent = Intent(this,DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickevents() {
        binding.button.setOnClickListener {
            val notificationService = NotificationService(applicationContext)

            notificationService.showNotification()

        }


        binding.button2.setOnClickListener {
            val notificationService = NotificationService(applicationContext)

            notificationService.showNotification_image()
        }
 binding.button3.setOnClickListener {
            val notificationService = NotificationService(applicationContext)

            notificationService.showNotification_deeplink()
        }


    }


}




















