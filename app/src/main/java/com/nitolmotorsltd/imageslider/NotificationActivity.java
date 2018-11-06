package com.nitolmotorsltd.imageslider;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class NotificationActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "simplified_coding";
    private static final String CHANNEL_NAME = "Simplified Coding";
    private static final String CHANNEL_DESC = "Simplified Coding Notifications";

    Button btn_display_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btn_display_notification = (Button) findViewById(R.id.btn_display_notification);
        btn_display_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayNotification();
            }
        });

    }

    public void displayNotification(){

        createNotificationChannel();

        RemoteViews notification_normal = new RemoteViews(getPackageName(), R.layout.small);
        RemoteViews notification_expand = new RemoteViews(getPackageName(), R.layout.big);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        mBuilder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        mBuilder.setCustomContentView(notification_normal);
        mBuilder.setCustomBigContentView(notification_expand);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(this);
        mNotificationMgr.notify(1, mBuilder.build());
    }

    public void createNotificationChannel(){
        // If the device OS version is 26 or above then we have to create the notification channel.
        // Otherwise notification will not work.

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }


}
