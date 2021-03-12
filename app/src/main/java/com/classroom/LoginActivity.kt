package com.classroom

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.classroom.R

class LoginActivity : AppCompatActivity() {
     lateinit var buttonLogin: TextView
     lateinit var buttonNotify: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.button_login)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //NotificationChannel channel = new NotificationChannel("My notification", "My notification", IMPORTANCE_DEFAULT)
            val channel = NotificationChannel("My notification", "My notification", IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }

        buttonNotify = findViewById(R.id.get_notify)
        buttonNotify.setOnClickListener{
            var builder = NotificationCompat.Builder(this, "My notification")
            builder.setContentTitle("My notification Title")
            builder.setContentText("Hello from my application, this a simple notification")
            builder.setSmallIcon(R.drawable.ic_email)
            builder.setAutoCancel(true)

            //NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(1, builder.build())
        }
    }
}