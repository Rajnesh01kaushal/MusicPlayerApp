package com.example.hp.sevicesandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class myService extends Service {

    MediaPlayer mediaPlayer;
    int playPosition;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.excuses);

        mediaPlayer.setLooping(true);
        }

    @Override
    public int onStartCommand(Intent intent, int flag, int startId) {
        
        super.onStart(intent,startId);

        
        if (intent.getStringArrayExtra("order").equals("play")) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
        else
            if (intent.getStringExtra("order").equals("pause")) {
            playPosition =mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            }
            else
                if (intent.getStringExtra("order").equalsIgnoreCase("resume")) {
            mediaPlayer.seekTo(playPosition);
            mediaPlayer.start();
                }
        Toast.makeText(this, "resume the song", Toast.LENGTH_SHORT).show();

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "stop song", Toast.LENGTH_SHORT).show();

        mediaPlayer.stop();
    }
}
