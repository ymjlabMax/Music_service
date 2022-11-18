package com.example.service_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {

    private MediaPlayer player;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        Log.d("음악 재생", "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy(){
        Log.d("음악 재생 스톱", "onCreate()");
        player.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("음악 호출", "onCreate()");

        player = MediaPlayer.create(this, R.raw.music);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}