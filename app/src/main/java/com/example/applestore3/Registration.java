package com.example.applestore3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // EditText
        EditText txt_id =findViewById(R.id.clientid);
        EditText txt_name = findViewById(R.id.clientname);
        EditText txt_mail = findViewById(R.id.clientmail);
        EditText txt_pwd = findViewById(R.id.clientpwd);
        EditText txt_pwd_conf = findViewById(R.id.clientpwdconfirm);
        // Button
        Button btn_reg = findViewById(R.id.btn_registre);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper db = new DataBaseHelper(registration.this);

                //The Student ID is already existing in the database or not.
                if(db.validate(Integer.parseInt(txt_id.getText().toString()))){
                    Toast.makeText(registration.this, "ID is already exists", Toast.LENGTH_SHORT).show();
                }
                else{
                    //The entered password in the field txtStudentPass is not null
                    if(txt_pwd.getText().toString().trim().equals("")){
                        Toast.makeText(registration.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        //The entered password in the field txtConfirmPass is identical to the password entered in
                        //the field txtStudentPass.
                        if(txt_pwd.getText().toString().trim().equals(txt_pwd_conf.getText().toString().trim())){
                            if(db.insertNewClient(Integer.parseInt(txt_id.getText().toString()),
                                    txt_pwd.getText().toString(), txt_name.getText().toString(),
                                    txt_mail.getText().toString()))
                                Toast.makeText(registration.this, "Data Inserted", Toast.LENGTH_SHORT).show();;
                        }
                        else
                            Toast.makeText(registration.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}