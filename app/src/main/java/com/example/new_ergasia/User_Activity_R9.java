package com.example.new_ergasia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class User_Activity_R9 extends AppCompatActivity {
    private BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_r9);


        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        // Get reference to the TextView in your MainActivity layout file
        TextView textView = findViewById(R.id.appointment_text);

        // Set a click listener on the TextView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the User_Activity_R9 activity using intent3 object
                Intent intent3 = new Intent(User_Activity_R9.this, Choose_a_Doctor_R9.class);
                startActivity(intent3);
            }
        });


        bottomNav = findViewById(R.id.BottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(User_Activity_R9.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        // Handle dashboard button click
                        return true;
                    case R.id.back:
                        Intent intent2 = new Intent(User_Activity_R9.this, MainActivity_R1.class);
                        startActivity(intent2);
                        finish();
                        return true;
                    default:
                        return false;
                }
            }


        });


    }


    }
