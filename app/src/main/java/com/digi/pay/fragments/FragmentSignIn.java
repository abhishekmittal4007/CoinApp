package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.custom.buttons.ExtraBoldTextButton;
import com.digi.pay.custom.edittexts.MediumEditText;
import com.digi.pay.custom.textviews.BoldTextView;
import com.digi.pay.custom.textviews.ExtraBoldTextView;
import com.digi.pay.ui.CreateAccountActivity_;
import com.digi.pay.ui.MainActivity_;
import com.digi.pay.utils.PreferenceManger;
import com.digi.pay.utils.Utility;
import com.digi.pay.view_models.SignUpPojo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EFragment(R.layout.fragment_sign_in)
public class FragmentSignIn extends Fragment {

    @ViewById(R.id.et_password)
    MediumEditText et_password;

    @ViewById(R.id.et_phone_number)
    MediumEditText et_phone_number;

    @ViewById(R.id.show_pass_btn)
    ImageView show_pass_btn;

    @ViewById(R.id.txt_forgot)
    ExtraBoldTextButton txt_forgot;

    @ViewById(R.id.txt_create_acc)
    ExtraBoldTextView txt_create_acc;

    @ViewById(R.id.header)
    BoldTextView header;

    boolean isShowPassword = false;

    SignUpPojo signUpPojo;

    @Click(R.id.txt_forgot)
    public void forgotPass() {
        Utility.showFragment(getActivity(), new Fragment_ForgotPassword_()
                , R.id.main_frame, null, Fragment_ForgotPassword.class.getSimpleName());
    }

    @AfterViews
    public void init() {

        if (Utility.isUserAlreadyLogin)
        {
            et_phone_number.setVisibility(View.GONE);
            txt_forgot.setVisibility(View.GONE);
            txt_create_acc.setVisibility(View.GONE);

            signUpPojo = PreferenceManger.getObject("signup_data");

            header.setText("Welcome " + signUpPojo.getFullname() );
        }
        else
        {
            et_phone_number.setVisibility(View.VISIBLE);
            txt_forgot.setVisibility(View.VISIBLE);
            txt_create_acc.setVisibility(View.VISIBLE);
            header.setText("Sign Up");
        }

    }

    @Click(R.id.txt_create_acc)
    public void setCreateAccount() {
        Intent intent = new Intent(getActivity(), CreateAccountActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.btn_singin)
    public void btnSignIn() {
        if (Utility.isUserAlreadyLogin)
        {
            AlreadyLoginValidations();
        }
        else
        {
            Validations();
        }

        /*Intent intent = new Intent(getActivity(), MainActivity_.class);
        startActivity(intent);*/
    }

    @Click(R.id.show_pass_btn)
    public void ShowHidePass() {
        if (isShowPassword) {
            et_password.setTransformationMethod(new PasswordTransformationMethod());
            show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye));
            isShowPassword = false;
        } else {
            et_password.setTransformationMethod(null);
            show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_cut_eye));
            isShowPassword = true;
        }

    }

    public void Validations() {
        if (et_phone_number.getText().length() > 0 && et_password.getText().length() > 0) {
            if (et_phone_number.getText().toString().replaceAll("-", "").length() != 10) {
                Toast.makeText(getActivity(), "Phone Number must be of 10 Digit", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(getActivity(), MainActivity_.class);
                startActivity(intent);
                requireActivity().finish();
            }
        } else {
            Toast.makeText(getActivity(), "Please Fill-Up All Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void AlreadyLoginValidations() {
        if (et_password.getText().length() > 0) {
            /** commented by arul on 25 feb 21 as per the client requirement */
           /* if (!et_password.getText().toString().equalsIgnoreCase(signUpPojo.getPassword())) {
                Toast.makeText(getActivity(), "Incorrect Password", Toast.LENGTH_SHORT).show();
            } else {*/
                Intent intent = new Intent(getActivity(), MainActivity_.class);
                startActivity(intent);
                requireActivity().finish();
          //  }
        } else {
            Toast.makeText(getActivity(), "Please Enter Password to use this App", Toast.LENGTH_SHORT).show();
        }
    }

}
