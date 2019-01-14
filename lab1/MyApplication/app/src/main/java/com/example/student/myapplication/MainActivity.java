package com.example.student.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.util.Log;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    public void sendMessage(View view)
    {
        // Do something in response to button click
        EditText name = (EditText)findViewById(R.id.name);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText email = (EditText)findViewById(R.id.email);
        EditText password = (EditText)findViewById(R.id.password);

        boolean email_b=(TextUtils.isEmpty(email.getText()));
        boolean email_len=Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches();
        boolean name_b=(TextUtils.isEmpty(name.getText()));
        boolean password_b=(TextUtils.isEmpty(password.getText()));
        boolean phone_b= (phone.getText().length()==10);

        if(!name_b && !password_b && !email_b && phone_b){
            if(email_len){
                Toast toast = Toast.makeText(getApplicationContext(),"correct details entered",
                        Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"wrong details",
                    Toast.LENGTH_SHORT);
            toast.show();
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

