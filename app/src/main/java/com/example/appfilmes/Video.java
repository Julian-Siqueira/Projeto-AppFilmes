package com.example.appfilmes;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video extends AppCompatActivity {

    private VideoView telaVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().hide();

        inicializarComponents();

        String video = getIntent().getStringExtra("video");
        telaVideo.setMediaController(new MediaController(this));
        telaVideo.setVideoURI(Uri.parse(video));
        telaVideo.requestFocus();
        telaVideo.start();


    }

    private void inicializarComponents() {

        telaVideo = findViewById(R.id.tela_video);
    }
}