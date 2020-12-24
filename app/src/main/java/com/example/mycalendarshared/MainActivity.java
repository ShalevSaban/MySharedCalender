package com.example.mycalendarshared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.dialer.dialpadview.DialpadView;
import com.hbb20.CountryCodePicker;

import im.dlg.dialer.DialpadActivity;

public class MainActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText PhoneNumber;
    Button sendSmsCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        Utils.hideSystemUI(decorView);
        PhoneNumber=(EditText)findViewById(R.id.phoneNumber);
        ccp=(CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(PhoneNumber);
        sendSmsCode=(Button)findViewById(R.id.sendSmsCode);
        sendSmsCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, verifyAndSignin.class);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });

      //  inflateFragment(getString(R.string.LoginFragment), false, null);


    }




    protected void onResume() {
        super.onResume();
    }
















}

