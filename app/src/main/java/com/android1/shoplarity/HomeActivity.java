package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity{
    @BindView(R.id.grid1)
    GridView imageGrid;
    private String[]names={"Clothes","Shoes","Cars","Furniture","Devices","Phones","Antique"};
    private int[] foto_id={R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5,R.drawable.foto6,R.drawable.foto7};
    @BindView(R.id.hello)
    TextView greet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String greeting = intent.getStringExtra("name");
        categoryAdapter categoryAdapter=new categoryAdapter(HomeActivity.this,foto_id,names);
        imageGrid.setAdapter(categoryAdapter);
        imageGrid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //this is switch case to help me get to a specific activity depending on the pressed Image
                switch (position){
                    case 0:
                        Intent intent1=new Intent(HomeActivity.this,ClothesActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2=new Intent(HomeActivity.this,ShoesActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3=new Intent(HomeActivity.this,carsActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4=new Intent(HomeActivity.this,furnitureActivity.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5=new Intent(HomeActivity.this,devicesActivity.class);
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6=new Intent(HomeActivity.this,mobilephoneactivity.class);
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7=new Intent(HomeActivity.this,AntiquityActivity.class);
                        startActivity(intent7);
                        break;
                }

                Toast.makeText(getApplicationContext(),((TextView) view.findViewById(R.id.textView)).getText(),Toast.LENGTH_SHORT).show();
            }
        });
        greet.setText("Welcome  "+greeting);


    }

}
