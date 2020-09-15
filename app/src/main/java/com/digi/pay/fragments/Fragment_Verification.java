package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.ui.CreateAccountActivity;
import com.digi.pay.ui.MainActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_verification)
public class Fragment_Verification extends Fragment {

    @AfterViews
    public void init() {
        if (((CreateAccountActivity) requireActivity()).step_indicator != null) {
            ((CreateAccountActivity) requireActivity()).step_indicator.setCurrentStep(2);
        }
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
