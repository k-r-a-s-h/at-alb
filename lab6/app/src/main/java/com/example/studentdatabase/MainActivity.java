package com.example.studentdatabase;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText name,surname,marks,id;
    Button btnAddData,viewdata,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.name);
        surname=(EditText)findViewById(R.id.surname);
        marks=(EditText)findViewById(R.id.marks);
        id=(EditText)findViewById(R.id.id);
        btnAddData=(Button)findViewById(R.id.btn_add);
        viewdata=(Button)findViewById(R.id.showdata);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);
        AddData();
        viewAll();
        updateData();
        deleteData();
    }
    public  void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  myDb.insertData(name.getText().toString(),surname.getText().toString(),marks.getText().toString());
               if(isInserted){
                   Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
               }
               else{
                   Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
    public void viewAll(){
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=myDb.getAllData();
                if(res.getCount() ==0){
                    showMessage("Error","No data found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("id: "+res.getString(0)+"\n");
                    buffer.append("Name: "+res.getString(1)+"\n");
                    buffer.append("Surname: "+res.getString(2)+"\n");
                    buffer.append("Marks: "+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());


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
    public  void  updateData(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated=myDb.updateData(id.getText().toString(),name.getText().toString(),surname.getText().toString(),marks.getText().toString());
                if(isUpdated){
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Data  NOT updated",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void deleteData(){
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer idDeleted = myDb.deleteData(id.getText().toString());
                if(idDeleted>0){
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

