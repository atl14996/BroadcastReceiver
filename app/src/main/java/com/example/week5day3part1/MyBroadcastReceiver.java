package com.example.week5day3part1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

            if(intent != null) {
                Bundle receivedBundle = intent.getBundleExtra("product_key");
                if(receivedBundle != null) {
                    Log.d("TAG", "onReceive: " + receivedBundle.toString());
                }

            }
        }
    }

