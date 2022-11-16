package com.example.mycoffeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mycoffeeapp.Adapters.OrdersAdapter;
import com.example.mycoffeeapp.Models.MainModels;
import com.example.mycoffeeapp.Models.OrdersModel;
import com.example.mycoffeeapp.databinding.ActivityMenuBinding;
import com.example.mycoffeeapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add((new OrdersModel(R.drawable.tea,"tea","5","hello ")));
        list.add((new OrdersModel(R.drawable.tea5,"tea","50","hello ")));
        list.add((new OrdersModel(R.drawable.tea4,"tea","10","hello ")));
        list.add((new OrdersModel(R.drawable.tea3,"tdf","50","hello ")));
        list.add((new OrdersModel(R.drawable.tea3,"tea","50","hello ")));

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRview.setLayoutManager(layoutManager);



    }
}