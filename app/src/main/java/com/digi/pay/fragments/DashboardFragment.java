package com.digi.pay.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.digi.pay.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends Fragment {

    @ViewById(R.id.text_dashboard)
    TextView text_dashboard;

    @AfterViews
    public void init(){

    }
}