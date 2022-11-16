package com.example.mycoffeeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycoffeeapp.Models.OrdersModel;
import com.example.mycoffeeapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {


    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model = list.get(position);
        holder.orderImg.setImageResource(model.getOrderImage());
        holder.sitemname.setText(model.getSitemname());
        holder.ordernumber.setText(model.getOrdernumber());
        holder.price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImg;
        TextView sitemname, ordernumber, price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImg = itemView.findViewById(R.id.orderimg);
            sitemname = itemView.findViewById(R.id.ordername);
            ordernumber = itemView.findViewById(R.id.ordernumber);
            price = itemView.findViewById(R.id.orderprice);
        }
    }
}












