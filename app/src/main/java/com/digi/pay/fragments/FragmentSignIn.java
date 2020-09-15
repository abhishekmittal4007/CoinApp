package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.ui.CreateAccountActivity_;
import com.digi.pay.ui.MainActivity_;
import com.digi.pay.utils.Utility;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_sign_in)
public class FragmentSignIn extends Fragment {

    @Click(R.id.txt_forgot)
    public void forgotPass() {
        Utility.showFragment(getActivity(), new Fragment_ForgotPassword_()
                , R.id.main_frame, null, Fragment_ForgotPassword.class.getSimpleName());
    }

    @Click(R.id.txt_create_acc)
    public void setCreateAccount() {
        Intent intent = new Intent(getActivity(), CreateAccountActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.btn_singin)
    public void btnSignIn() {
        Intent intent = new Intent(getActivity(), MainActivity_.class);
        startActivity(intent);
    }
}
