package com.digi.pay.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.view_models.TransactionData;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder>{
    private ArrayList<TransactionData> listdata;

    Context mcontext;
    // RecyclerView recyclerView;
    public TransactionAdapter(Context context, ArrayList<TransactionData> listdata) {
        this.listdata = listdata;
        this.mcontext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.transaction_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TransactionData myListData = listdata.get(position);
       /* holder.textView.setText(listdata[position].getDescription());
        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });*/

      /* if (position==0)
       {
           holder.header_view.setVisibility(View.VISIBLE);
       }
       else
       {
           holder.header_view.setVisibility(View.GONE);
       }*/

        holder.userName.setText(myListData.getName());
        holder.time_value.setText(myListData.getTime());
        holder.credit_value.setText(myListData.getCredit());
        holder.debit_value.setText(myListData.getDebit());


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView userName,time_value,credit_value,debit_value;
       // public RelativeLayout header_view;
        public ViewHolder(View itemView) {
            super(itemView);
            this.userName = (TextView) itemView.findViewById(R.id.transaction_value);
            this.time_value = itemView.findViewById(R.id.time_value);
            this.credit_value = itemView.findViewById(R.id.credit_value);
            this.debit_value = itemView.findViewById(R.id.debit_value);

           // header_view = (RelativeLayout)itemView.findViewById(R.id.header_view);

        }
    }
}