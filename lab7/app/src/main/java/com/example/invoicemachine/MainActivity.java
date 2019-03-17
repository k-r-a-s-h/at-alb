package com.example.invoicemachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button viewinvoice,addproduct,max_min;
    public static DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewinvoice=(Button)findViewById(R.id.view_invoice);
        addproduct=(Button)findViewById(R.id.addtodb);
        max_min=(Button)findViewById(R.id.max_min);
        mydb = new DatabaseHelper(MainActivity.this);
        viewinvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), viewinvoice.class);
                startActivity(intent);

            }
        });

        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),addtodb.class);
                startActivity(intent);
            }
        });

        max_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),viewminmax.class);
                startActivity(intent);
            }
        });
    }
}
