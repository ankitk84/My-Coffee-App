package com.example.mycoffeeapp;

import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mycoffeeapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding  binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_detail);

        int image =  getIntent().getIntExtra("image",0);
        int price = parseInt(getIntent().getStringExtra("price"));
        String  name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("Desc");


        binding.detailimg.setImageResource(image);
        binding.pricelbl.setText(String.format("%d",price));
        binding.foodname.setText(name);

        final  DBHelper helper = new DBHelper(this);
        binding.orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//             if(isInserted)
//                 Toast.makeText(DetailActivity.this,"Data Success",Toast.LENGTH_SHORT).show();
//             else
//                 Toast.makeText(DetailActivity.this,"Error", Toast.LENGTH_SHORT).show();
            }
        });



    }
}