package com.example.new_ergasia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class List_of_Physio_R1 extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private ExampleDialog exampleDialog = new ExampleDialog();
    private final String myIP=new GetIp().getIp();
    private ArrayList<String> ListofPhysios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_physio_r1);

        //remove ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button createNewPhysio = findViewById(R.id.eisodos_admin_button);

        createNewPhysio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(List_of_Physio_R1.this, ThirdActivity_R1.class);
                startActivity(intent);
            }
        });


        TableLayout tableLayout = findViewById(R.id.table_physio_r1); // replace 'context' with your context object
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        String url = "http://"+myIP+"/LoginCheck/List_R1.php";
//        ArrayList<String> ListofPhysios = new ArrayList<>();
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            ListofPhysios = okHttpHandler.getListofPhysio_R1(url);


            for (int i=0; i<ListofPhysios.toArray().length; i+=3){          //kathe 3 stoixeia "allazei" h grammh gi afto exw i+3
                TableRow tableRow = new TableRow(this);             //Dhmioyrgw ena TableRow gia na valw ta stoixeia
                for (int j =0; j<3; j++){                               //egw thelw na parw ta 3 stoixeia ka8e fora
                    //System.out.println(ListofPhysios.get(i+j));                 //gi afto analoga to i vazw i+j
                    TextView textView = new TextView(this);             //gia kathe stoixeio dhmioyrgw ena TextView
                    textView.setText(ListofPhysios.get(i+j));               //vazw to Text toy kathe stoixeiou mesa sto TextView

                    TableRow.LayoutParams params = new TableRow.LayoutParams(   //Dhmiourgw parametrous gia na exoyn idio keno metaju toys
                            0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
                    textView.setLayoutParams(params);
                    textView.setGravity(Gravity.CENTER);                    //vazw ta TextView pou ftiaxnw sto kentro
                    tableRow.addView(textView);                              //to kanw add mesa sto tableRow pou exw ftiaxei
                }
                tableLayout.addView(tableRow);                  //meta to telow ths eswterikh epanalhpshs vazw to tableRow mesa sto tableLayout
            }



        } catch (Exception e) {
            e.printStackTrace();
        }



        bottomNav = findViewById(R.id.BottomNav);//Navigation Bar
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(List_of_Physio_R1.this, MainActivity_R1.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.help:
                        ExampleDialog exampleDialog = new ExampleDialog();
                        exampleDialog.setHeader("Help");
                        exampleDialog.setText("Please give a name,location and password for your physical therapy clinic.");
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


