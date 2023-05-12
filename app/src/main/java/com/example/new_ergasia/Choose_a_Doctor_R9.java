package com.example.new_ergasia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Choose_a_Doctor_R9 extends AppCompatActivity {



        private BottomNavigationView bottomNav;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_choose_adoctor_r9);

            //remove ActionBar
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();

            Button button = findViewById(R.id.availability_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the User_Activity_R9 activity using intent3 object
                    Intent intent = new Intent(Choose_a_Doctor_R9.this, Make_An_Appointment_R9.class);
                    startActivity(intent);
                }
            });

            bottomNav = findViewById(R.id.BottomNav);
            bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            Intent intent = new Intent(Choose_a_Doctor_R9.this, MainActivity_R1.class);
                            startActivity(intent);
                            finish();
                            return true;
                        case R.id.help:
                            // Handle dashboard button click
                            return true;
                        case R.id.back:
                            Intent intent2 = new Intent(Choose_a_Doctor_R9.this, User_Activity_R9.class);
                            startActivity(intent2);
                            finish();
                            return true;
                        default:
                            return false;
                    }
                }


            });


            //BOARD

    }
}