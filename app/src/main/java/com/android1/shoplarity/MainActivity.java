package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.getStarted)
    Button  getStarted;
    @BindView(R.id.name)
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getStarted.setOnClickListener(this);

}
    @Override
    public void onClick(View v) {//these codes will direct you to the next activity
        if (v== getStarted){
            String names =name.getText().toString();
            Intent intention =new Intent(MainActivity.this,HomeActivity.class);
            intention.putExtra("name",names);
            startActivity(intention);
        }
    }


}
