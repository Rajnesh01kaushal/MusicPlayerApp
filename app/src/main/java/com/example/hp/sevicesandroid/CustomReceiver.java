package com.example.hp.sevicesandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(""))
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }
}
