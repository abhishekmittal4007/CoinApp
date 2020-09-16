package com.digi.pay.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.digi.pay.R;
import com.digi.pay.custom.edittexts.MediumEditText;
import com.digi.pay.ui.CreateAccountActivity_;
import com.digi.pay.ui.MainActivity_;
import com.digi.pay.utils.Utility;

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

    boolean isShowPassword = false;

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
        Validations();
        /*Intent intent = new Intent(getActivity(), MainActivity_.class);
        startActivity(intent);*/
    }


    @Click(R.id.show_pass_btn)
    public void ShowHidePass()
    {
        if (isShowPassword)
        {
            et_password.setTransformationMethod(new PasswordTransformationMethod());
            show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye));
            isShowPassword  = false;
        }
        else
        {
            et_password.setTransformationMethod(null);
            show_pass_btn.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_eye)); // need to replace with cut eye
            isShowPassword  = true;
        }

    }

    public void Validations()
    {
        if (et_phone_number.getText().length()>0 && et_password.getText().length()>0)
        {
            if (et_phone_number.getText().toString().replaceAll("-","").length()!=10)
            {
                Toast.makeText(getActivity(), "Phone Number must be of 10 Digit", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent intent = new Intent(getActivity(), MainActivity_.class);
                startActivity(intent);
            }

        }
        else
        {
            Toast.makeText(getActivity(), "Please Fill-Up All Fields", Toast.LENGTH_SHORT).show();
        }
    }



}
