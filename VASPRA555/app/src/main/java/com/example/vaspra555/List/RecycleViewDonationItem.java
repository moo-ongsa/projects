package com.example.vaspra555.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaspra555.R;

import java.util.List;

public class RecycleViewDonationItem extends  RecyclerView.Adapter<RecycleViewDonationItem.MyViewHolder2>{

    Context context;
    List<Item> contactList;

    public RecycleViewDonationItem (Context context, List<Item> contactList) {
        this.context = context;
        this.contactList = contactList;
    }
    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.fragment_listdonation, parent, false);
        MyViewHolder2 myViewHolder2 = new MyViewHolder2(v);
        return myViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.tvdonationItem.setText(contactList.get(position).getDonationItem());

        holder.tvdonationAmount.setText(contactList.get(position).getDonationAmount());
        holder.tvdonationTotal.setText(contactList.get(position).getDonationTotal());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView tvdonationItem,tvdonationAmount,tvdonationTotal;



        public MyViewHolder2(View fragment_listdonation) {
            super(fragment_listdonation);
             tvdonationItem = (TextView) fragment_listdonation.findViewById(R.id.tvdonationItem);
            tvdonationAmount = (TextView) fragment_listdonation.findViewById(R.id.tvdonationAmount);
            tvdonationTotal = (TextView) fragment_listdonation.findViewById(R.id.tvdonationTotal);
        }
    }
}
