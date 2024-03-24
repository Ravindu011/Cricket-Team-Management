package com.example.cricketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Player extends AppCompatActivity {
  EditText Name,match,run,fif,hun,avg;
  Button add_button;
  Double rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Name=findViewById(R.id.Name);
        match=findViewById(R.id.editTextNumber);
        run=findViewById(R.id.editTextNumber2);
        fif=findViewById(R.id.editTextNumber4);
        hun =findViewById(R.id.editTextNumber5);
        avg=findViewById(R.id.editTextNumber7);

        add_button=findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBclass myDB = new DBclass(Add_Player.this);
                myDB.addplayer(
                        Name.getText().toString().trim(),
                        Integer.valueOf(match.getText().toString().trim()),
                        Integer.valueOf(run.getText().toString().trim()),
                        Integer.valueOf(fif.getText().toString().trim()),
                        Integer.valueOf(hun.getText().toString().trim()),
                        //rate.toString().trim()
                        avg.getText().toString().trim()


                );

                finish();
            }
        });

    }

    public void CalRate(){
        double runs = Double.parseDouble(run.getText().toString());
        double matches = Double.parseDouble(match.getText().toString());
        rate = runs / matches;

    }
}