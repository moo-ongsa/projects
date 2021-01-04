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

public class RycycleViewHistoProject extends  RecyclerView.Adapter<RycycleViewHistoProject.MyViewHolder> {

    Context context;
    List<HistoProject> contactList;

    public RycycleViewHistoProject(Context context, List<HistoProject> contactList) {
        this.context = context;
        this.contactList = contactList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.fragment_listprojecthistory, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.HistoryprojectSequence.setText(contactList.get(position).getHSsequence());
        holder.HistoryprojectDonate.setText(contactList.get(position).getHSDonate());
        holder.HistoryprojectType.setText(contactList.get(position).getHSType());
        holder.HistoryprojectDate.setText(contactList.get(position).getHSDate());
    }
    
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView HistoryprojectDonate,HistoryprojectType,HistoryprojectDate,HistoryprojectSequence;



        public MyViewHolder(View fragment_listprojecthistory) {
            super(fragment_listprojecthistory);
            HistoryprojectSequence = (TextView) fragment_listprojecthistory.findViewById(R.id.tvHistoryprojectSequence);
            HistoryprojectDonate = (TextView) fragment_listprojecthistory.findViewById(R.id.tvHistoryprojectDonate);
            HistoryprojectType = (TextView) fragment_listprojecthistory.findViewById(R.id.tvHistoryprojectType);
            HistoryprojectDate = (TextView) fragment_listprojecthistory.findViewById(R.id.tvHistoryprojectDate);
        }
    }
}
