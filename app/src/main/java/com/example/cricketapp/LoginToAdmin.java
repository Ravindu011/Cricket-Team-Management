package com.example.cricketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginToAdmin extends AppCompatActivity {

    Button btnView;
    EditText u,p;
    String un,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_admin);
        btnView = findViewById(R.id.btnLogIn);
        u=findViewById(R.id.user);
        p=findViewById(R.id.pw);



        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                un=u.getText().toString();
                pw=p.getText().toString();

                if ("ravi".equals(un) && "aaa".equals(pw)){
                    Intent intent=new Intent(getApplicationContext(), Admin_Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginToAdmin.this,"Invalid Login",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}