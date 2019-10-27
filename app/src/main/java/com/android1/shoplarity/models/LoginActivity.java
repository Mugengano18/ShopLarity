package com.android1.shoplarity.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android1.shoplarity.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.registerText)TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==register){
            Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
