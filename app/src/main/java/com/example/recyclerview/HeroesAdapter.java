package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private ArrayList<HeroesModel> ListHero = new ArrayList<>();
    private Context context;

    public HeroesAdapter(ArrayList<HeroesModel> listHero, Context context) {
        this.ListHero = listHero;
        this.context = context;
    }

    public ArrayList<HeroesModel> getListHero() {
        return ListHero;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(getListHero().get(position).getHeroImg()).into(holder.ivHero);
        holder.tvName.setText(getListHero().get(position).getHeroName());
        holder.tvDetail.setText(getListHero().get(position).getHeroDetail());

        holder.ivHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nama Hero : "+getListHero().get(position).getHeroName(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() { //NGULANG DATANYA MAU BERAPA KALI
        return getListHero().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHero;
        TextView tvName, tvDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHero = itemView.findViewById(R.id.itemhero_img);
            tvName = itemView.findViewById(R.id.itemhero_tv_nama);
            tvDetail = itemView.findViewById(R.id.itemhero_tv_deskripsi);
        }
    }
}
