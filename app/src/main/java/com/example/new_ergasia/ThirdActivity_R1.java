package com.example.new_ergasia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ThirdActivity_R1 extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private ExampleDialog exampleDialog = new ExampleDialog();
    private ArrayList<String> ListofPhysios = new ArrayList<>();
    private final String myIP=new GetIp().getIp();//Gia na mhn allazw synexeia thn IP
    private boolean DoesPhysioExist,DoesAFMexist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);//Poio layout na parei

        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button createPhysio = findViewById(R.id.eisodos_admin_button);

        createPhysio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pairnw ta TextView
                TextView name = findViewById(R.id.name_physio);
                TextView location = findViewById(R.id.location_physio);
                TextView AFM = findViewById(R.id.pass_login_r1);

                String name_Physio,location_Physio,AFM_Physio;
                //Ta metatrepw se Strings
                name_Physio = name.getText().toString();
                location_Physio = location.getText().toString();
                AFM_Physio = AFM.getText().toString();


                String url = "http://"+myIP+"/LoginCheck/List_R1.php";
//        ArrayList<String> ListofPhysios = new ArrayList<>();
                try {
                    OkHttpHandler okHttpHandler = new OkHttpHandler();
                    ListofPhysios = okHttpHandler.getListofPhysio_R1(url);

                } catch (Exception e) {
                    e.printStackTrace();
                }


                //Elegxos gia ta onomata
                String errorMessage="";

                if (name_Physio.matches("[a-zA-Z]+") && name_Physio.length()>=3){

                }else {
                    errorMessage+="The name of the Physiotherapy must not have special characters and it" +
                            " should include at least 3 characters.";

                }
                if (location_Physio.matches("[a-zA-Z0-9 ]+") && location_Physio.length()>=5){

                }else{
                    errorMessage+="The location of the Physiotherapy must not have special characters and it" +
                            " should include at least 5 characters and a number.";

                }
                if (AFM_Physio.matches("[0-9]+") && AFM_Physio.length()==9){

                }else{
                    errorMessage+="The AFM of the Physiotherapy must not have special characters nor letters and it" +
                            " should be 9 numbers.";

                }
                DoesPhysioExist = false;
                DoesAFMexist = false;
                for (int i=0; i<ListofPhysios.toArray().length; i+=3){ //elegxw an to onoma kai to AFM yparxei hdh
                    if (ListofPhysios.get(i).equals(name_Physio) || ListofPhysios.get(i+2).equals(AFM_Physio)){
                        DoesPhysioExist = true;
                        DoesAFMexist = true;
                    }
                }

                if (name_Physio.matches("[a-zA-Z]+") && name_Physio.length()>=3
                        &&location_Physio.matches("[a-zA-Z0-9 ]+")
                        && location_Physio.length()>=5 && AFM_Physio.matches("[0-9]+") && AFM_Physio.length()==9
                        && name_Physio.equals("Enter name")==false && location_Physio.equals("Enter location")==false
                        && AFM_Physio.equals("Enter AFM")==false){
                    if (DoesPhysioExist==false && DoesAFMexist==false){ //Elegxw an to onoma uparxei kai to AFM hdh sthn vash dedomenwn
                        //Ta stelnw sthn vash dedomenwn
                        url= "http://"+myIP+"/LoginCheck/AddPhysio.php?name=" + name_Physio +
                                "&address=" + location_Physio + "&afm=" + AFM_Physio;
                        try {
                            OkHttpHandler okHttpHandler = new OkHttpHandler();
                            okHttpHandler.logHistory(url);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exampleDialog.setHeader("Message");
                        exampleDialog.setText("The Physiotherapy was created.");
                        exampleDialog.show(getSupportFragmentManager(),"example dialog");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(ThirdActivity_R1.this, MainActivity_R1.class);
                                startActivity(intent);
                            }
                        }, 4000);//Meta apo 4 defterolepta stelnw ton xrhsth sthn arxikh o8onh
                    }
                    else {//Se periptwsh pou to onoma yparxei emfanizw auto to message
                        ExampleDialog exampleDialog = new ExampleDialog();
                        exampleDialog.setHeader("Error");
                        exampleDialog.setText("The name or the AFM  already exist.");
                        exampleDialog.show(getSupportFragmentManager(),"example dialog");
                    }


                }
                else {
                    ExampleDialog exampleDialog = new ExampleDialog();
                    exampleDialog.setHeader("Error");
                    exampleDialog.setText(errorMessage);
                    exampleDialog.show(getSupportFragmentManager(),"example dialog");
                }

            }
        });



        bottomNav = findViewById(R.id.BottomNav);//Navigation Bar
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(ThirdActivity_R1.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        ExampleDialog exampleDialog = new ExampleDialog();
                        exampleDialog.setHeader("Help");
                        exampleDialog.setText("Please give a name,location and AFM for your physical therapy clinic.");
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

