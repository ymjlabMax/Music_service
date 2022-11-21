package com.example.service_music;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MusicService extends Service {

    private MediaPlayer player;

    public static final String CHANNEL_ID = "ForegroundServiceChannel";

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

        String input = intent.getStringExtra("inputExtra");

        createNotificationChannel();

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("음악 어플 실행 ")
                .setContentText("음악 재생 중 입니다.")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .build();


        startForeground(1, notification);



        player = MediaPlayer.create(this, R.raw.music);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

   private void createNotificationChannel(){
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           NotificationChannel serviceChannel = new NotificationChannel(
                   CHANNEL_ID,
                   "Foreground Service Channel",
                   NotificationManager.IMPORTANCE_DEFAULT
           );

           NotificationManager manager = getSystemService(NotificationManager.class);
           assert manager != null;
           manager.createNotificationChannel(serviceChannel);
       }
   }




}