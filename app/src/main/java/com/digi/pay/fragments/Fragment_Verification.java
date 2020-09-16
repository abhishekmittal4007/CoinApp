package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.custom.textviews.BoldTextView;
import com.digi.pay.ui.CreateAccountActivity;
import com.digi.pay.ui.MainActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_verification)
public class Fragment_Verification extends Fragment {

    @ViewById(R.id.codeletter1)
    BoldTextView codeLetter1;
    @ViewById(R.id.codeletter2)
    BoldTextView codeLetter2;
    @ViewById(R.id.codeletter3)
    BoldTextView codeLetter3;
    @ViewById(R.id.codeletter4)
    BoldTextView codeLetter4;
    @ViewById(R.id.codeletter5)
    BoldTextView codeLetter5;
    @ViewById(R.id.codeletter6)
    BoldTextView codeLetter6;

    ProgressDialog progressDialog;

    @AfterViews
    public void init() {
        if (((CreateAccountActivity) requireActivity()).step_indicator != null) {
            ((CreateAccountActivity) requireActivity()).step_indicator.setCurrentStep(2);
        }

        Handler handler2 = new Handler();
        handler2.postDelayed(() -> {
            codeLetter1.setText("1");
            codeLetter2.setText("2");
            codeLetter3.setText("3");
            codeLetter4.setText("4");
            codeLetter5.setText("5");
            codeLetter6.setText("6");

        }, 800); // 3000 milliseconds delay

    }

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    @Click(R.id.btn_verify)
    public void setVerify() {
        Intent intent = new Intent(requireActivity(), MainActivity_.class);
        startActivity(intent);
    }
}
