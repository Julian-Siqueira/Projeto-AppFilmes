package com.example.appfilmes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appfilmes.Model.Filme;
import com.example.appfilmes.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.FilmeViewHolder> {

    private Context context;
    private List<Filme> filmeList = new ArrayList<>();

    public AdapterFilme(Context context, List<Filme> filmeList) {
        this.context = context;
        this.filmeList = filmeList;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        itemList = layoutInflater.inflate(R.layout.filme_item, parent, false);
        return new FilmeViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        Glide.with(context).load(filmeList.get(position).getCapa()).into(holder.capa);
        holder.titulo.setText(filmeList.get(position).getTitulo());

    }

    @Override
    public int getItemCount() {
        return filmeList.size();
    }

    public class FilmeViewHolder extends RecyclerView.ViewHolder{

        private ImageView capa;
        private TextView titulo;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
            capa = itemView.findViewById(R.id.capa_filme);
            titulo = itemView.findViewById(R.id.titulo_filme);
        }
    }
}
