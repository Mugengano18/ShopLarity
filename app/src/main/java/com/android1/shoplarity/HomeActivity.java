package com.android1.shoplarity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.grid1)
    GridView imageGrid;
    private String[]names={"Clothes","Shoes","Cars","Furniture","Devices","Phones","Antique"};
    private int[] foto_id={R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5,R.drawable.foto6,R.drawable.foto7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        imageGrid=(GridView)findViewById(R.id.grid1);

        imageGrid=(GridView) findViewById(R.id.grid1);

        categoryAdapter categoryAdapter=new categoryAdapter(HomeActivity.this,foto_id,names);
        imageGrid.setAdapter(categoryAdapter);
        imageGrid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String index=names[position];
                if(index=="1"){
                        Intent intention1=new Intent(HomeActivity.this,ClothesActivity.class);
                        startActivity(intention1);
                    }else if(index=="2"){
                        Intent intention2=new Intent(HomeActivity.this,ShoesActivity.class);
                        startActivity(intention2);
                    }
                    else if(index=="3"){
                        Intent intention3=new Intent(HomeActivity.this,carsActivity.class);
                        startActivity(intention3);
                    }
                    else if(index=="4"){
                        Intent intention4=new Intent(HomeActivity.this,furnitureActivity.class);
                        startActivity(intention4);
                    }
                    else if(index=="5"){
                        Intent intention5=new Intent(HomeActivity.this,ShoesActivity.class);
                        startActivity(intention5);
                    }
                    else if(index=="6"){
                        Intent intention6=new Intent(HomeActivity.this,ShoesActivity.class);
                        startActivity(intention6);
                    }
                    else if(index=="7"){
                        Intent intention7=new Intent(HomeActivity.this,ShoesActivity.class);
                        startActivity(intention7);
                    }

                Toast.makeText(getApplicationContext(),((TextView) view.findViewById(R.id.textView)).getText(),Toast.LENGTH_SHORT).show();
            }
        });


    }

}
