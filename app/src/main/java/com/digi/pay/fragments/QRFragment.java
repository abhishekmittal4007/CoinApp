package com.digi.pay.fragments;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.google.zxing.integration.android.IntentIntegrator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_qr)
public class QRFragment extends Fragment {

    private IntentIntegrator qrScan;

    @AfterViews
    public void init(){

        //intializing scan object
        qrScan = new IntentIntegrator(getActivity());

        //initiating the qr code scan
        qrScan.initiateScan();
        qrScan.setOrientationLocked(true);

    }
}

