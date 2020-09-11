package com.digi.pay.fragments;

import android.content.Intent;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.adapters.TransactionAdapter;
import com.digi.pay.ui.ReceiveActivity_;
import com.digi.pay.ui.SendActivity_;
import com.digi.pay.view_models.TransactionData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @ViewById(R.id.transaction_list)
    RecyclerView recyclerView;
    @ViewById(R.id.send_btn)
    RelativeLayout send_btn;
    @ViewById(R.id.recieve_btn)
    RelativeLayout receive_btn;

    ArrayList<TransactionData> myListData;

    @AfterViews
    public void init() {
        myListData = new ArrayList<>();

        myListData.add(new TransactionData("Ajit Singh", "June 18, 2020 11:55 Am", " - ", " - 45 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Shaurya", "June 25, 2020 09:15 Pm", " - ", " -100 Cn "));
        myListData.add(new TransactionData("Ajit Singh", "June 18, 2020 11:55 Am", " - ", " - 45 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Shaurya", "June 25, 2020 09:15 Pm", " - ", " -100 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));

        TransactionAdapter adapter = new TransactionAdapter(getActivity(), myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Click(R.id.send_btn)
    public void sendButtonClicked() {
        Intent i = new Intent(getActivity(), SendActivity_.class);
        startActivity(i);
    }

    @Click(R.id.recieve_btn)
    public void recieveButtonClicked() {
        Intent i = new Intent(getActivity(), ReceiveActivity_.class);
        startActivity(i);
    }
}