package com.digi.pay.fragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digi.pay.R;
import com.digi.pay.adapters.TransactionAdapter;
import com.digi.pay.ui.MainActivity;
import com.digi.pay.view_models.TransactionData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_notifications)
public class NotificationsFragment extends Fragment {

    @ViewById(R.id.noti_transaction_list)
    RecyclerView noti_transaction_list;

    ArrayList<TransactionData> myListData;

    @ViewById(R.id.fab)
    FloatingActionButton fab;

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
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Shaurya", "June 25, 2020 09:15 Pm", " - ", " -100 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Shaurya", "June 25, 2020 09:15 Pm", " - ", " -100 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));
        myListData.add(new TransactionData("Shaurya", "June 25, 2020 09:15 Pm", " - ", " -100 Cn "));
        myListData.add(new TransactionData("Ramveer", "June 19, 2020 12:35 Am", " + 29 Cn ", " - "));
        myListData.add(new TransactionData("Ankita", "June 21, 2020 02:10 Pm", " +300 Cn ", " - "));

        TransactionAdapter adapter = new TransactionAdapter(getActivity(), myListData);
        noti_transaction_list.setHasFixedSize(true);
        noti_transaction_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        noti_transaction_list.setAdapter(adapter);
    }

    @Click(R.id.fab)
    public void showNotificationButton() {

        sendNotification();

    }


    private void sendNotification(){
        int notification_id = (int) System.currentTimeMillis();
        NotificationManager notificationManager = null;
        NotificationCompat.Builder mBuilder;

        String title = "DigiPay";
        String body = "Coins Receive";

        //Set pending intent to builder
        Intent intent = new Intent(getActivity(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_ONE_SHOT);

        //Notification builder
        if (notificationManager == null){
            notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        }


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notificationManager.getNotificationChannel("CHANNEL_ID");
            if (mChannel == null){
                mChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", importance);
                mChannel.setDescription("CHANNEL_DESCRIPTION");
                mChannel.enableVibration(true);
                mChannel.setLightColor(Color.GREEN);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(mChannel);
            }

            mBuilder = new NotificationCompat.Builder(getActivity(), "CHANNEL_ID");
            mBuilder.setContentTitle(title)
                    .setSmallIcon(R.drawable.ic_bell)
                    .setContentText(body) //show icon on status bar
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setDefaults(Notification.DEFAULT_ALL);
        }else {
            mBuilder = new NotificationCompat.Builder(getActivity());
            mBuilder.setContentTitle(title)
                    .setSmallIcon(R.drawable.ic_bell)
                    .setContentText(body)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setDefaults(Notification.DEFAULT_VIBRATE);
        }

        notificationManager.notify(1002, mBuilder.build());
    }



}