package com.example.new_ergasia;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Login_R1 extends AppCompatActivity {

    private final String myIP=new GetIp().getIp();
    private ExampleDialog exampleDialog = new ExampleDialog();
    private BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_r1);
        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

       Button login = findViewById(R.id.eisodos_admin_button);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pairnw to Text kai to metatrepw se String gia na dw an einai ta idia me thn vash
                TextView TextName = findViewById(R.id.name_physio);
                TextView TextPass = findViewById(R.id.pass_login_r1);

                String nameGiven = TextName.getText().toString();
                String passGiven = TextPass.getText().toString();

                String url = "http://"+myIP+"/LoginCheck/Login.php";
                ArrayList<String> AdminInfo = new ArrayList<String>();
                try {
                    OkHttpHandler okHttpHandler = new OkHttpHandler();
                    AdminInfo = okHttpHandler.getAdmininfo(url);
                    if (AdminInfo.get(0).equals(nameGiven) && AdminInfo.get(1).equals(passGiven)){
                        Intent intent = new Intent(Login_R1.this, List_of_Physio_R1.class);
                        startActivity(intent);
                    }
                    else {
                        exampleDialog.setHeader("Something is wrong");
                        exampleDialog.setText("Please check the name and the password.");
                        exampleDialog.show(getSupportFragmentManager(),"example dialog");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        bottomNav = findViewById(R.id.BottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(Login_R1.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        exampleDialog.setHeader("Help");
                        exampleDialog.setText("Please give the name and the password to login.");
                        exampleDialog.show(getSupportFragmentManager(),"example dialog");
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
}
