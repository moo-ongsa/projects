package com.example.vaspra555.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vaspra555.R;

import java.util.List;
public  class RecycleViewAdapter {


/*
    public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    List<Product> contactList;

    public RecycleViewAdapter(Context context, List<Product> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
       // v = LayoutInflater.from(context).inflate(R.layout.itemproduct, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(contactList.get(position).getName());
        holder.phone_num.setText(contactList.get(position).getPhn());
        holder.imageView.setImageResource(contactList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView phone_num;
        ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);

           name = (TextView) itemView.findViewById(R.id.name_contact);
            phone_num = (TextView) itemView.findViewById(R.id.ph_number);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }*/
}
