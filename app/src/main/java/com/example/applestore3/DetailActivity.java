package com.example.applestore3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        ImageView img = findViewById(R.id.img_phone);
        TextView txtmodel = findViewById(R.id.txt_model);
        TextView txtprice = findViewById(R.id.txt_price);

        int position = i.getIntExtra("position", 0);
//        img.setImageResource(Data.phones[position].getImage());
        txtmodel.setText(Data.phones[position].getModel());
        txtprice.setText(String.valueOf(Data.phones[position].getPrix()));

        Button btn = findViewById(R.id.btn_buy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, BuyPhone.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }
}