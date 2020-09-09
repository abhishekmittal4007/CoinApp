package com.digi.pay.ui;

import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.Models.RecentSendData;
import com.digi.pay.R;
import com.digi.pay.adapters.RecentSendAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import java.util.ArrayList;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.send_activity)
public class SendActivity extends AppCompatActivity {

    @ViewById(R.id.recent_sends)
    RecyclerView recent_sends;

    ArrayList<RecentSendData> myListData;

    @AfterViews
    public void init() {
        myListData = new ArrayList<>();

        myListData.add(new RecentSendData("David Warner", "4589865986", "www.google.com"));
        myListData.add(new RecentSendData("Mitch", "5898565852", "www.google.com"));
        myListData.add(new RecentSendData("Warne", "2545868965", "www.google.com"));
        myListData.add(new RecentSendData("Clay Jenson", "4578956852", "www.google.com"));
        myListData.add(new RecentSendData("Ajit Singh", "3568598568", "www.google.com"));
        myListData.add(new RecentSendData("Ramveer", "5847125689", "www.google.com"));
        myListData.add(new RecentSendData("Ankita", "2145897956", "www.google.com"));
        myListData.add(new RecentSendData("Shaurya", "8856458925", "www.google.com"));
        myListData.add(new RecentSendData("Tom Benton", "4576892535", "www.google.com"));
        myListData.add(new RecentSendData("Justin Folley", "1459798652", "www.google.com"));

        RecentSendAdapter adapter = new RecentSendAdapter(SendActivity.this, myListData);
        recent_sends.setHasFixedSize(true);
        recent_sends.setLayoutManager(new LinearLayoutManager(SendActivity.this));
        recent_sends.setAdapter(adapter);
    }
}
