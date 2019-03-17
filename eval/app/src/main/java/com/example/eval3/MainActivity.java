package com.example.eval3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.intent.MESSAGE";
    TextView op1 ,op2;
    CheckBox sin,mod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op1=(TextView)findViewById(R.id.editText);
        op2=(TextView)findViewById(R.id.editText2);
        sin =(CheckBox)findViewById(R.id.checkBox);
        mod =(CheckBox)findViewById(R.id.checkBox2);

    }


    public void calculate(View view) {
        int q1=Integer.parseInt(op1.getText().toString());
        int q2=Integer.parseInt(op2.getText().toString());

        if(sin.isChecked() && mod.isChecked()){
            float ans1 = q1%q2;
            double ans2 = q1+q2;
            double ans=Math.toRadians(ans2);
            double answer= Math.sin(ans);


            Intent intent = new Intent(getApplicationContext(), DisplayMessage.class);

            intent.putExtra(EXTRA_MESSAGE,Float.toString(ans1)+"\n"+Double.toString(answer) );
            startActivity(intent);

        }
        else if(mod.isChecked()){
            float ans = q1%q2;


            Intent intent = new Intent(getApplicationContext(), DisplayMessage.class);

            intent.putExtra(EXTRA_MESSAGE,Float.toString(ans) );
            startActivity(intent);

        }


        else if(sin.isChecked()){
            double ans2 = q1+q2;
            double ans=Math.toRadians(ans2);
            double answer= Math.sin(ans);
            Intent intent = new Intent(getApplicationContext(), DisplayMessage.class);

            intent.putExtra(EXTRA_MESSAGE,Double.toString(answer) );
            startActivity(intent);

        }

    }
}
