package com.rayhung.actest1.UI;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rayhung.actest1.R;

public class Splash extends AppCompatActivity {

    private static long SPLASH_MILLIS = 1550;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        checkInternet();
    }

    private void checkInternet(){
        ConnectivityManager mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

//如果未連線的話，mNetworkInfo會等於null
        if(mNetworkInfo != null)
        {
            initialContent();
        }else{
        }
    }

    private void initialContent(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(Splash.this, MainActivity.class);
                startActivity(intent);

                Splash.this.finish();

            }
        }, SPLASH_MILLIS);
    }

}
