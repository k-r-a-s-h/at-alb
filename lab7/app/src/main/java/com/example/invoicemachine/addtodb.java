package com.example.invoicemachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.invoicemachine.MainActivity.mydb;

public class addtodb extends AppCompatActivity {

    EditText p_name,description,price,quantity;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodb);

        mydb = new DatabaseHelper(this);
        p_name=(EditText)findViewById(R.id.p_name);
        description=(EditText)findViewById(R.id.description);
        price=(EditText)findViewById(R.id.price);
        quantity=(EditText)findViewById(R.id.quantity);

        submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=mydb.insertproduct(p_name.getText().toString(),description.getText().toString(),price.getText().toString(),quantity.getText().toString());
                if(isInserted){
                    Toast.makeText(addtodb.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(addtodb.this,"Data Not Inserted",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
