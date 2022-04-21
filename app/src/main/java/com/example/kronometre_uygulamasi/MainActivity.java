package com.example.kronometre_uygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity<view, z> extends AppCompatActivity {

    int zamanidurdur =0;
    long elapsedMillis;


    Button btnstart,btnpause,btnreset;
    ImageView imageView,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.btnstart);
        btnreset=(Button)findViewById(R.id.btnreset);
        btnpause=(Button)findViewById(R.id.btnpause);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        Chronometer chronometer=(Chronometer)findViewById(R.id.kronometre);


        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime()+zamanidurdur);
                chronometer.start();
                btnstart.setVisibility(View.GONE);
                btnpause.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getDrawable(R.drawable.pause));


            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                btnpause.setVisibility(View.GONE);
                btnstart.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getDrawable(R.drawable.start));
            }

            private void showElapsedTime() {
                long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                Toast.makeText(MainActivity.this,"Elapsed milliseconds: " + elapsedMillis, Toast.LENGTH_SHORT).show();
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
                zamanidurdur=0;
                btnpause.setVisibility(View.GONE);
                btnstart.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getDrawable(R.drawable.start));
            }
        });




    }

}