package com.example.mycoffeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.mycoffeeapp.Adapters.MainAdapter;
import com.example.mycoffeeapp.Models.MainModels;
import com.example.mycoffeeapp.databinding.ActivityMenuBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {


   ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModels> list = new ArrayList<>();
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));
        list.add((new MainModels(R.drawable.tea,"tea","50","hello ")));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.Rview.setAdapter(adapter);

        LinearLayoutManager layoutManager  = new LinearLayoutManager(this);
        binding.Rview.setLayoutManager(layoutManager);

    }
}