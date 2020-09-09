package com.digi.pay.fragments;

import android.content.Intent;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.Models.TransactionData;
import com.digi.pay.R;
import com.digi.pay.adapters.HomeViewModel;
import com.digi.pay.adapters.TransactionAdapter;
import com.digi.pay.ui.SendActivity;
import com.digi.pay.ui.SendActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @ViewById(R.id.transaction_list)
    RecyclerView recyclerView;

    ArrayList<TransactionData> myListData;
    @ViewById(R.id.send_btn)
    RelativeLayout send_btn;
    @ViewById(R.id.receive_btn)
    RelativeLayout receive_btn;

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        init();
//        return root;
//    }

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
    public void sedButtonClicked() {
        Intent i = new Intent(getActivity(), SendActivity_.class);
        startActivity(i);
    }
}