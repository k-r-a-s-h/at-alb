package com.example.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.Expression;

public class MainActivity extends AppCompatActivity {
    TextView outlet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outlet = (TextView) findViewById(R.id.textView2);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"1");
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"2");
            }
        });
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"1");
            }
        });
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"4");
            }
        });
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"5");
            }
        });
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"6");
            }
        });
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"7");
            }
        });
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"8");
            }
        });
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"9");
            }
        });
        Button btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"0");
            }
        });
        Button btn_add = (Button) findViewById(R.id.button_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"+");
            }
        });
        Button btn_sub = (Button) findViewById(R.id.button_sub);
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"-");
            }
        });
        Button btn_mul = (Button) findViewById(R.id.button_mul);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"*");
            }
        });
        Button btn_div = (Button) findViewById(R.id.button_div);
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"/");
            }
        });
        Button btn_mod = (Button) findViewById(R.id.button_modulo);
        btn_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText(outlet.getText()+"%");
            }
        });
        Button btn_solve = (Button) findViewById(R.id.button_solve);
        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression expr = new Expression(outlet.getText().toString());
                try {
                    outlet.setText(expr.eval().toString());
                }
                catch(ArithmeticException e){
                    outlet.setText("Invalid operation");
                }
            }
        });
        Button btn_clr = (Button) findViewById(R.id.button_clear);
        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outlet.setText("");
            }
        });
        Button btn_del = (Button) findViewById(R.id.button_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expr = outlet.getText().toString();
                outlet.setText(expr.substring(0, expr.length()-1));
            }
        });
    }
}
