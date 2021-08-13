package com.droidguru.fcmintegration;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;


public class NotificationReceiver extends BroadcastReceiver {
    NotificationManager notificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {

        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(intent.hasExtra("ID"))
        {
            int noteId = intent.getIntExtra("ID",0);
            notificationManager.cancel(noteId);

        }else {
            Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
            if (remoteInput != null) {
                CharSequence feedback = remoteInput.getCharSequence("DirectReplyNotification");
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.notification_logo)
                        .setContentTitle("Thank you for your feedback!!!");

                notificationManager.notify(0, mBuilder.build());
            }

        }

    }
}
