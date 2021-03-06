package com.digi.pay.fragments;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.adapters.TransactionAdapter;
import com.digi.pay.custom.textviews.RegularTextView;
import com.digi.pay.custom.textviews.SemiBoldTextView;
import com.digi.pay.ui.ReceiveActivity_;
import com.digi.pay.ui.SendActivity_;
import com.digi.pay.ui.SignInActivity_;
import com.digi.pay.utils.PreferenceManger;
import com.digi.pay.view_models.TransactionData;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_home_)
public class HomeFragment extends Fragment {

    @ViewById(R.id.transaction_list)
    RecyclerView recyclerView;

    @ViewById(R.id.username)
    SemiBoldTextView username;

    @ViewById(R.id.logout)
    RegularTextView logout;

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


        if (PreferenceManger.getObject("signup_data")!=null)
        {
            username.setText(PreferenceManger.getObject("signup_data").getFullname());
        }


    }

    @Click(R.id.send_btn)
    public void sendButtonClicked() {
        Intent i = new Intent(getActivity(), SendActivity_.class);
        startActivity(i);
    }

    @Click({R.id.recieve_btn, R.id.header_view})
    public void recieveButtonClicked() {
        Intent i = new Intent(getActivity(), ReceiveActivity_.class);
        startActivity(i);
    }

    @Click(R.id.logout)
    public void logoutButtonClicked() {
        PreferenceManger.logoutUser();
        Intent i = new Intent(getActivity(), SignInActivity_.class);
        startActivity(i);
        getActivity().finish();
    }


}