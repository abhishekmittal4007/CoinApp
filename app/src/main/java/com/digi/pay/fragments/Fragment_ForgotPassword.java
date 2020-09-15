package com.digi.pay.fragments;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_forgot_password)
public class Fragment_ForgotPassword extends Fragment {

    @Click(R.id.btn_back)
    public void setBack() {
        requireActivity().getSupportFragmentManager().popBackStack();
    }

    @Click(R.id.btn_singin)
    public void setSignIn() {
        Utility.showFragment(getActivity(), new FragmentNewPassword_()
                , R.id.main_frame, null, FragmentNewPassword.class.getSimpleName());
    }
}
