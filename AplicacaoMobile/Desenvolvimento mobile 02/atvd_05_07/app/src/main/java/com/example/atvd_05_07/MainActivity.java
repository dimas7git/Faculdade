package com.example.atvd_05_07;

import android.os.Bundle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity{

    public static final String PREFS_NAME = "prefs";
    public static final String PREFS_ONLINE_KEY = "online";
    public static final String PREFS_IMAGE_INDEX_KEY = "imageIndex";

    private ImageView imgEstrela;
    private Button btnInterruptor;
    private Button btnInterruptor2;
    private boolean online;

    private int[] images = {
            android.R.drawable.ic_delete,
            android.R.drawable.ic_lock_power_off,
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_help
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgEstrela = (ImageView) findViewById(R.id.imgEstrela);
        btnInterruptor = (Button) findViewById(R.id.btnInterruptor);
        btnInterruptor2 = (Button) findViewById(R.id.btnInterruptor2);

        btnInterruptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxImagem();
            }
        });

        btnInterruptor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltaImagem();
            }
        });

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        online = settings.getBoolean(PREFS_ONLINE_KEY, false);
        currentIndex = settings.getInt(PREFS_IMAGE_INDEX_KEY, 0);

        imgEstrela.setImageResource(images[currentIndex]);
    }

    public void proxImagem() {
        currentIndex = (currentIndex + 1) % images.length;
        imgEstrela.setImageResource(images[currentIndex]);
        setOnline(false);
    }

    public void voltaImagem() {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
        imgEstrela.setImageResource(images[currentIndex]);
        setOnline(false);
    }

    protected void setOnline(boolean online) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PREFS_ONLINE_KEY, online);
        editor.putInt(PREFS_IMAGE_INDEX_KEY, currentIndex);
        editor.commit();
    }
}