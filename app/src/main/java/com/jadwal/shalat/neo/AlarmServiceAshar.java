package com.jadwal.shalat.neo;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by ACER on 5/5/2017.
 */

public class AlarmServiceAshar extends IntentService {
    private NotificationManager alarmNotificationManager;

    public AlarmServiceAshar() {
        super("AlarmServiceImsak");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Ashar! Ashar!");
    }

    private void sendNotification(String msg) {
        Log.d("AlarmServiceImsak", "Preparing to send notification...: " + msg);
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Jadwal Sholat").setSmallIcon(android.R.drawable.alert_dark_frame)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);


        alamNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("AlarmServiceImsak", "Notification sent.");
    }
}
