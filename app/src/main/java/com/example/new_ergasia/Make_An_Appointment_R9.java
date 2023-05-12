package com.example.new_ergasia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Make_An_Appointment_R9 extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_an_appointment_r9);

        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        bottomNav = findViewById(R.id.BottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(Make_An_Appointment_R9.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        // Handle dashboard button click
                        return true;
                    case R.id.back:
                        Intent intent2 = new Intent(Make_An_Appointment_R9.this, Choose_a_Doctor_R9.class);
                        startActivity(intent2);
                        finish();
                        return true;
                    default:
                        return false;
                }
            }


        });


    // CALENDAR
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // This method will be called when a new date is selected in the calendar
                // You can perform any necessary actions here based on the selected date
            }
        });










    }
}