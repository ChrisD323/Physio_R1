package com.example.new_ergasia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.new_ergasia.databinding.ActivitySecondR1Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity_R1 extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    private ActivitySecondR1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_r1);

        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding = ActivitySecondR1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.createPhysioText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity_R1.this, ThirdActivity_R1.class);
                startActivity(intent);
            }
        });



        bottomNav = findViewById(R.id.BottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(SecondActivity_R1.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        // Handle dashboard button click
                        return true;
                    case R.id.back:
                        onBackPressed();
                        return true;
                    default:
                        return false;
                }
            }


        });


    }

    public int dsadsa(int x){
        return 5;
    }




}

