package com.classroom.courseregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendNotificationActivity extends AppCompatActivity implements View.OnClickListener {
    int notificationID=0;
    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button buttonSendNotification;

    private NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);
        notificationManager = NotificationManagerCompat.from(this);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
        buttonSendNotification=findViewById(R.id.button_send_notification);
        buttonSendNotification.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        sendNotification();
    }
    public void sendNotification(){
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        notificationID++;
        Notification notification = new NotificationCompat.Builder(SendNotificationActivity.this, App.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setBigContentTitle(title)
                        .bigText(message))
                .setContentTitle(title)
                .setContentText(message)
                .setContentText(message)
                .setLights(ContextCompat.getColor(
                        getApplicationContext(), R.color.black), 1000, 1000)
                .setAutoCancel(true)
                .setGroupSummary(true)
                .build();
        notificationManager.notify(notificationID, notification);
    }
}