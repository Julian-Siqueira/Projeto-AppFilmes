package com.example.appfilmes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilmes.Adapter.AdapterFilme;
import com.example.appfilmes.Model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilmes;
    private List<Filme> listFilmes;
    private AdapterFilme adapterFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        listFilmes = new ArrayList<>();
        adapterFilme = new AdapterFilme(getApplicationContext(), listFilmes);
        recyclerViewFilmes.setAdapter(adapterFilme);
        recyclerViewFilmes.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerViewFilmes.setHasFixedSize(true);
        filmes();



    }

    private void filmes() {

        Filme filme1 = new Filme(R.drawable.ic_launcher_foreground, "filme 1");
        listFilmes.add(filme1);
        Filme filme2 = new Filme(R.drawable.ic_launcher_background, "filme 2");
        listFilmes.add(filme2);
        Filme filme3 = new Filme(R.drawable.ic_launcher_foreground, "filme 3");
        listFilmes.add(filme3);
        Filme filme4 = new Filme(R.drawable.ic_launcher_background, "filme 4");
        listFilmes.add(filme4);
        Filme filme5 = new Filme(R.drawable.ic_launcher_foreground, "filme 5");
        listFilmes.add(filme5);
        Filme filme6 = new Filme(R.drawable.ic_launcher_background, "filme 6");
        listFilmes.add(filme6);

    }

    private void inicializarComponentes() {
        recyclerViewFilmes = findViewById(R.id.recyclerView_Filmes);
    }
}