package com.crown.quuickseriesdemo

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationService(
    private val context: Context
) {

    companion object{
        const val CHANNEL_ID_1 = "Channel_01"
        const val CHANNEL_ID_2 = "Channel_02"
        const val CHANNEL_ID_3 = "Channel_03"
    }

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(){
        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.putExtra("Company","QuickSeries--Notification1")
        activityIntent.putExtra("Position","Android Developer")
        val activityPendingIntent = PendingIntent.getActivity(context,1,activityIntent,
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) PendingIntent.FLAG_UPDATE_CURRENT else 0)




        val notification = NotificationCompat.Builder(context, CHANNEL_ID_1).setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("Notification Title")
            .setContentText("Notification Text")
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(1,notification)
    }



    fun showNotification_image(){
        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.putExtra("Company","QuickSeries--Notification2")
        activityIntent.putExtra("Position","Android Developer")
        activityIntent.putExtra("Image","https://png.pngtree.com/png-clipart/20210921/ourmid/pngtree-canada-flag-brush-png-image_3949046.png")
        val activityPendingIntent = PendingIntent.getActivity(context,1,activityIntent,
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) PendingIntent.FLAG_UPDATE_CURRENT else 0)




        val notification = NotificationCompat.Builder(context, CHANNEL_ID_1).setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("Notification _2_ Title")
            .setContentText("Notification Text")
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(1,notification)
    }




    fun showNotification_deeplink(){
        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.putExtra("Company","QuickSeries-- Notification3")
        activityIntent.putExtra("Position","Android Developer")
        activityIntent.putExtra("URI","Details")
        val activityPendingIntent = PendingIntent.getActivity(context,1,activityIntent,
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) PendingIntent.FLAG_UPDATE_CURRENT else 0)




        val notification = NotificationCompat.Builder(context, CHANNEL_ID_1).setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
            .setContentTitle("Notification _3 _Title")
            .setContentText("Notification Text")
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(1,notification)
    }

}