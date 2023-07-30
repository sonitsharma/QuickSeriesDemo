package com.crown.quuickseriesdemo

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class QuickSeriesApplication :Application() {
    val channelArray = mutableListOf<NotificationChannel>()

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel(NotificationService.CHANNEL_ID_1,
                "Channel1",
                NotificationManager.IMPORTANCE_DEFAULT)

            val channel2 = NotificationChannel(NotificationService.CHANNEL_ID_2,
                "Channel_image",
                NotificationManager.IMPORTANCE_DEFAULT)

            val channel3 = NotificationChannel(NotificationService.CHANNEL_ID_3,
                "Channel_deepLink",
                NotificationManager.IMPORTANCE_DEFAULT)


            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            channelArray.add(channel)
            channelArray.add(channel2)
            channelArray.add(channel3)
            notificationManager.createNotificationChannels(channelArray)
        }
    }
}