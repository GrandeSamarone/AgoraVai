package com.example.fulanoeciclano.agoravai.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.fulanoeciclano.agoravai.Activity.MainActivity;
import com.example.fulanoeciclano.agoravai.R;

/**
 * Created by fulanoeciclano on 16/01/2018.
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash_screen);
        delaysplash();
    }

    public void delaysplash(){
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }


    @Override
    protected void onRestart() {
        delaysplash();
        super.onRestart();
    }


}

