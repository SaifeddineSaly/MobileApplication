package com.example.applestore3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_id = findViewById(R.id.et_id);
        EditText et_pwd = findViewById(R.id.et_pwd);
        Button btn_login = findViewById(R.id.btn_login);
        TextView tv_create = findViewById(R.id.btn_create);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper db = new DataBaseHelper(MainActivity.this);

                if(db.validate(Integer.parseInt(et_id.getText().toString()), et_pwd.getText().toString())){
                    Intent i = new Intent(MainActivity.this, home.class);
                    startActivity(i);
                } else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Mobile App Login Form");
                    builder.setMessage("Invalid Client ID or Password");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }
            }
        });
    }
    public void createAccount(View v) {
        Intent i = new Intent(this, registration.class);
        startActivity(i);
    }
}