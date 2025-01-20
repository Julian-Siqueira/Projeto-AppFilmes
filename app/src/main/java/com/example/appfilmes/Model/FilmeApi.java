package com.example.appfilmes.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmeApi {

    @GET("filmes.json?alt=media&token=10cd1d2d-4f5c-477f-bbcc-72578f355c83")
    Call<List<Filme>> getFilmes();
}
