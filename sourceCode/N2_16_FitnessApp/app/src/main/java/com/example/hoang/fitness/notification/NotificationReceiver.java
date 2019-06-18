package com.example.hoang.fitness.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
//
        Intent i = new Intent("Exercise");

        System.out.println("\n\n" + action);

        switch(action){
            case "next":
                i.putExtra("next", "next");
                i.putExtra("currentPos", intent.getIntExtra("currentPos", 0));
                i.putExtra("readyTime", intent.getIntExtra("readyTime", 0));
                i.putExtra("isFinish", intent.putExtra("isFinish", false));
                i.putExtra("isPlaying", intent.putExtra("isPlaying", true));

                break;
            case "prev":
                i.putExtra("prev", "prev");
                i.putExtra("currentPos", intent.getIntExtra("currentPos", 0));
                i.putExtra("readyTime", intent.getIntExtra("readyTime", 0));
                i.putExtra("isFinish", intent.putExtra("isFinish", false));
                i.putExtra("isPlaying", intent.putExtra("isPlaying", true));
                break;
            case "pause":
                i.putExtra("pause", "pause");
                i.putExtra("currentPos", intent.getIntExtra("currentPos", 0));
                i.putExtra("readyTime", intent.getIntExtra("readyTime", 0));
                i.putExtra("isFinish", intent.putExtra("isFinish", false));
                i.putExtra("isPlaying", intent.putExtra("isPlaying", true));
                break;
                default:
                    break;
        }

        context.sendBroadcast(i);

        String message = intent.getStringExtra("toastMessage");
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
