package com.example.mycoffeeapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycoffeeapp.DetailActivity;
import com.example.mycoffeeapp.Models.MainModels;
import com.example.mycoffeeapp.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{

    ArrayList<MainModels> list;
    Context context;

    public MainAdapter(ArrayList<MainModels> list, Context context) {
        this.list = list;
        this.context =context;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_coffee,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModels models = list.get(position);

        holder.teaimage.setImageResource(models.getImage());
        holder.name.setText(models.getName());
        holder.price.setText(models.getPrice());
        holder.description.setText(models.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",models.getImage());
                intent.putExtra("price", models.getPrice());
                intent.putExtra("desc",models.getDescription());
                intent.putExtra("name",models.getName());
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView teaimage;
        TextView name,price,description;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            teaimage = itemView.findViewById(R.id.tea);
            name = itemView.findViewById(R.id.teaname);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);
        }
    }
}
