package com.example.hp.sevicesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop;
    String order =null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.plybtn);
        pause = findViewById(R.id.pusbtn);
        stop = findViewById(R.id.stpbtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, myService.class);
                order = "play";
                intent.putExtra("order",order);
                play.setText("Resume");
                startService(intent);

                play.setEnabled(false);
                pause.setEnabled(true);
                stop.setEnabled(true);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,myService.class);
                order = "pause";
                intent.putExtra("order",order);
                play.setText("Resume");
                startService(intent);

                pause.setEnabled(false);
                stop.setEnabled(true);
                play.setEnabled(true);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,myService.class);
                order ="pause";
                intent.putExtra("order",order);
                startService(intent);

                pause.setEnabled(false);
                stop.setEnabled(true);
                play.setEnabled(true);
            }
        });

    }
}
