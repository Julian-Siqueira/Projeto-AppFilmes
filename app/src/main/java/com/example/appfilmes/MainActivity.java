package com.example.appfilmes;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilmes.Adapter.AdapterFilme;
import com.example.appfilmes.Model.Filme;
import com.example.appfilmes.Model.FilmeApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        //Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://firebasestorage.googleapis.com/v0/b/app-delivery-4daa9.firebasestorage.app/o/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Iniciar a Retrofit
        FilmeApi filmeApi = retrofit.create(FilmeApi.class);
        Call<List<Filme>> listCall = filmeApi.getFilmes();

        listCall.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                if (response.code() != 200){
                    return;
                }
                List<Filme> filmes = new ArrayList<>();
                filmes = response.body();

                for (Filme filme : filmes){
                    listFilmes.add(filme);
                }
                adapterFilme = new AdapterFilme(getApplicationContext(), listFilmes);
                recyclerViewFilmes.setAdapter(adapterFilme);
                recyclerViewFilmes.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                recyclerViewFilmes.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {

            }
        });
    }

    private void inicializarComponentes() {
        recyclerViewFilmes = findViewById(R.id.recyclerView_Filmes);
    }
}