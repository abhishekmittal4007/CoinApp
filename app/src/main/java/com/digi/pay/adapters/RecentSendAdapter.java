package com.digi.pay.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.ui.SendConfirmActivity_;
import com.digi.pay.view_models.RecentSendData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentSendAdapter extends RecyclerView.Adapter<RecentSendAdapter.ViewHolder>{
    private ArrayList<RecentSendData> listdata;

    Context mcontext;
    // RecyclerView recyclerView;
    public RecentSendAdapter(Context context, ArrayList<RecentSendData> listdata) {
        this.listdata = listdata;
        this.mcontext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recent_send_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RecentSendData myListData = listdata.get(position);
        holder.username.setText(myListData.getName());
        holder.phone_number.setText(myListData.getNumber());

        holder.mainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle basket = new Bundle();
                basket.putString("account_number", myListData.getNumber());
                basket.putString("account_name", myListData.getName());
                Intent i = new Intent(mcontext, SendConfirmActivity_.class);
                i.putExtras(basket);
                mcontext.startActivity(i);
            }
        });


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView username,phone_number;
         public RelativeLayout mainview;
        CircleImageView profilePhoto;
        public ViewHolder(View itemView) {
            super(itemView);
            this.username = (TextView) itemView.findViewById(R.id.username);
            this.phone_number = itemView.findViewById(R.id.phone_number);
            this.profilePhoto = itemView.findViewById(R.id.profilePhoto);

             mainview = (RelativeLayout)itemView.findViewById(R.id.mainview);

        }
    }
}