package com.example.appfilmes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;


public class Detalhes_Filme extends AppCompatActivity {

    private TextView tituloDetalhes, descricaoDetalhes, elencoDetalhes;
    private ImageView capaDetalhes, videoDetalhes;
    private Toolbar toolbarDetalhes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);
        getSupportActionBar().hide();

        inicializarComponentes();

        Intent intent = getIntent();
        Glide.with(getApplicationContext()).load(intent.getStringExtra("capa")).into(capaDetalhes);
        tituloDetalhes.setText(intent.getStringExtra("titulo"));
        descricaoDetalhes.setText(intent.getStringExtra("descricao"));
        elencoDetalhes.setText(intent.getStringExtra("elenco"));
        String video = intent.getStringExtra("video");
        String stVideo = video;


        toolbarDetalhes.setOnClickListener(v ->{
            finish();
        });

        videoDetalhes.setOnClickListener(view -> {
            Intent telaVideo = new Intent(getApplicationContext(), Video.class);
            telaVideo.putExtra("video", stVideo);
            startActivity(telaVideo);

        });

    }



    private void inicializarComponentes() {

        tituloDetalhes = findViewById(R.id.titulo_detalhes);
        capaDetalhes = findViewById(R.id.capa_detalhes);
        descricaoDetalhes = findViewById(R.id.descricao_detalhes);
        elencoDetalhes = findViewById(R.id.elenco_detalhes);
        videoDetalhes = findViewById(R.id.play_videos);
        toolbarDetalhes = findViewById(R.id.toolbar_detalhes);
    }
}