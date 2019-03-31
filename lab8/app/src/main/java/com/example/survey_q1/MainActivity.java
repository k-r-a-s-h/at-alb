package com.example.survey_q1;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit,view_result;
    RadioButton ans1,ans2,ans3,ans4;
    public  static  DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(MainActivity.this);
        submit=findViewById(R.id.submit);
        view_result=findViewById(R.id.view_result);
        ans1=findViewById(R.id.ans1);
        ans2=findViewById(R.id.ans2);
        ans3=findViewById(R.id.ans3);
        ans4=findViewById(R.id.ans4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ans11=ans1.isChecked();
                boolean ans22=ans2.isChecked();
                boolean ans33=ans3.isChecked();
                boolean ans44=ans4.isChecked();


                if(!(ans11 || ans22 || ans33 || ans44)){
                    Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean check=mydb.insertRecord(ans11, ans22, ans33, ans44);
                    if(check){
                        Toast.makeText(getApplicationContext(), "Inserted successfully",Toast.LENGTH_LONG ).show();
                    }
                }
            }
        });


        view_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= mydb.getAllData();

                int ans_1=0,ans_2=0,ans_3=0,ans_4=0;

                if(res.getCount()>0){
                    while (res.moveToNext()){
                        ans_1 +=Integer.parseInt(res.getString(1));
                        ans_2 +=Integer.parseInt(res.getString(2));
                        ans_3 +=Integer.parseInt(res.getString(3));
                        ans_4 +=Integer.parseInt(res.getString(4));

                    }

                    showMessage("DATA COLLECTION", "Ans1:"+ans_1+"\nAns2:"+ans_2+"\nAns3:"+ans_3+"\nAns4:"+ans_4);
                }
                else{
                    Toast.makeText(getApplicationContext(), "no data available", Toast.LENGTH_LONG).show();
                }

            }
        });




    }
    public void  showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
