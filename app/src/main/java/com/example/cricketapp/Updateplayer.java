package com.example.cricketapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Updateplayer extends AppCompatActivity {

    EditText Name2,Match,Score,fif,hun,editNumber7;
    Button update_button , delete_button;

    String id,name,match,runs,fifty,hund,rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Name2=findViewById(R.id.Name2);
        Match =findViewById(R.id.editNumber);
        Score =findViewById(R.id.editNumber2);
        fif =findViewById(R.id.editNumber4);
        hun =findViewById(R.id.editNumber5);
        editNumber7 =findViewById(R.id.editNumber7);
        update_button = findViewById(R.id.update_button);
        delete_button =findViewById(R.id.delete_button);
        getIntentData();

        ActionBar ab =getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBclass myDB = new DBclass(Updateplayer.this);
                myDB.updateData(
                        id,
                        Name2.getText().toString().trim(),
                        Integer.parseInt(Match.getText().toString().trim()),
                        Integer.parseInt(Score.getText().toString().trim()),
                        Integer.parseInt(fif.getText().toString().trim()),
                        Integer.parseInt(hun.getText().toString().trim()),
                        editNumber7.getText().toString().trim()

                );

            }
        });
  delete_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       confirm();
      }
  });

    }
     void getIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("Name") &&
                getIntent().hasExtra("Match") && getIntent().hasExtra("Runs") &&
                getIntent().hasExtra("50") && getIntent().hasExtra("100")
                && getIntent().hasExtra("rate")){
               id =getIntent().getStringExtra("id");
               name =getIntent().getStringExtra("Name");
               match =getIntent().getStringExtra("Match");
               runs =getIntent().getStringExtra("Runs");
               fifty =getIntent().getStringExtra("50");
               hund =getIntent().getStringExtra("100");
               rate =getIntent().getStringExtra("rate");

            Name2.setText(name);
            Match.setText(match);
            Score.setText(runs);
            fif.setText(fifty);
            hun.setText(hund);
            editNumber7.setText(rate);


        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
     }

    void confirm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete "  + name  + " ?");
        builder.setMessage("Are you sure want to delete "  +  name  + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBclass myDB = new DBclass(Updateplayer.this);
                myDB.deleteoneRow(id);
                finish(); // close activity after deletion
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing
            }
        });
        builder.create().show();
    }
}