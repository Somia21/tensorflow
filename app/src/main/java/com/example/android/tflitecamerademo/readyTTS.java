package com.example.android.tflitecamerademo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class readyTTS extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_tts);
        ReadyTextToSpeak("text to speach ready","en");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                startActivity(new Intent(readyTTS.this,CameraActivity.class));
            }
        };
    }
    private void ReadyTextToSpeak(String textToSpeak,String len) {
        Intent i = new Intent(this, TTSService.class);
        i.putExtra("toSpeak", textToSpeak);
        i.putExtra("Language", len);
        this.startService(i);
    }
    @Override
    protected void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(this).registerReceiver((broadcastReceiver),
                new IntentFilter("com.service.result"));
    }
    @Override
    protected void onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        super.onStop();
    }
}
