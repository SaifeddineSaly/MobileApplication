package com.example.applestore3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_phone);

        Button btn_buy = findViewById(R.id.btn_buy_buy);
        EditText et_qt = findViewById(R.id.et_buy_qt);
        EditText et_name = findViewById(R.id.et_buy_name);

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_name.getText().toString().equals("") || et_qt.getText().toString().equals(""))
                    Toast.makeText(BuyPhone.this, "Please fill data", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = getIntent();
                    int position = intent.getIntExtra("index", 0);
                    double prix = Data.phones[position].getPrix();
                    double total = prix * Integer.parseInt(et_qt.getText().toString());
                    Toast.makeText(BuyPhone.this, "Total Price is: " + String.valueOf(total), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}