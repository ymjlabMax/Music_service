package com.example.service_music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_btn;
    Button stop_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_btn = findViewById(R.id.play_btn);
        stop_btn = findViewById(R.id.stop_btn);



        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);
                Toast.makeText(MainActivity.this, "음악을 재생합니다", Toast.LENGTH_SHORT).show();

                Log.e("메인 엑티티비","서비스 호출" );
            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                stopService(intent);
                Toast.makeText(MainActivity.this, "음악을 중지합니다.", Toast.LENGTH_SHORT).show();
                Log.e("메인 엑티티비","음악 멈춤" );
            }
        });


    }
}