package com.example.cricketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewPlayers extends AppCompatActivity {

    RecyclerView recyclerView;
    DBclass myDB;
    ArrayList<String> pl_id,ply_name,ply_match,ply_runs,ply_50,ply_100,ply_rate;
    CustomViewAdapter1 customViewAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_players);
        recyclerView =findViewById(R.id.recyclerView1);

        myDB = new DBclass(ViewPlayers.this);
        pl_id = new ArrayList<>();
        ply_name = new ArrayList<>();
        ply_match = new ArrayList<>();
        ply_runs = new ArrayList<>();
        ply_50= new ArrayList<>();
        ply_100 = new ArrayList<>();
        ply_rate= new ArrayList<>();

        StoreDataArray();
        customViewAdapter1 = new CustomViewAdapter1(ViewPlayers.this, this,pl_id, ply_name, ply_match,ply_runs,ply_50,ply_100,ply_rate);
        recyclerView.setAdapter(customViewAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewPlayers.this));

    }
    void  StoreDataArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Team Empty", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                pl_id.add(cursor.getString(0));
                ply_name.add(cursor.getString(1));
                ply_match.add(cursor.getString(2));
                ply_runs.add(cursor.getString(3));
                ply_50.add(cursor.getString(4));
                ply_100.add(cursor.getString(5));
                ply_rate.add(cursor.getString(6));

            }
        }
    }
}