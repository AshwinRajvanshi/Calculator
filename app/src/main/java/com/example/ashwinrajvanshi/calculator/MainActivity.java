package com.example.ashwinrajvanshi.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnpow;
    Button btnSqrt,btnper;


    TextView tvResult;


    String oper = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

              etNum1 = (EditText) findViewById(R.id.etNum1);
              etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnpow=(Button) findViewById(R.id.btnpow);
        btnSqrt=(Button) findViewById(R.id.btnSqrt);
        btnper=(Button) findViewById(R.id.btnper);





        tvResult = (TextView) findViewById(R.id.tvResult);

              btnAdd.setOnClickListener(this);
              btnSub.setOnClickListener(this);
              btnMult.setOnClickListener(this);
              btnDiv.setOnClickListener(this);
              btnSqrt.setOnClickListener(this);
              btnpow.setOnClickListener(this);
              btnper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           double num1 = 0.0;
           double num2 = 0.0;
           double result = 0.0;

             if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
              return;
        }

           num1 = Double.parseDouble(etNum1.getText().toString());
           num2 = Double.parseDouble(etNum2.getText().toString());


         switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
             case R.id.btnper:
                 oper = "%";
                 result = num1 /(num2)*100;
                 break;

             case R.id.btnSqrt:
                 oper = "Sqrt";
                 if(num1!=0.0)
                 result = sqrt(num1);
                 else
                     {
                     result=sqrt(num2);
                 }
                 break;
             case R.id.btnpow:
                 oper = "^";
                 result = Math.pow(num1,num2);
                 break;
             case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }


        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}