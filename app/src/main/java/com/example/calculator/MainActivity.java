package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    TextView zeroTv,oneTv, twoTv,threeTv,fourTv,fiveTv,sixTv,sevenTv,eightTv,nineTv;
    TextView addTv,subTv,mulTv,divTv,clearTv,dotTv,equalTv,openTv,closeTv;
    TextView resultTv, exprTv;
    ImageView back;
    boolean canBePressed = true;
    boolean canMinusPressed = true, isOpen = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zeroTv = findViewById(R.id.tvZero_ID);
        oneTv = findViewById(R.id.tvOne_ID);
        twoTv = findViewById(R.id.tvTwo_ID);
        threeTv = findViewById(R.id.tvThree_ID);
        fourTv = findViewById(R.id.tvFour_ID);
        fiveTv = findViewById(R.id.tvFive_ID);
        sixTv = findViewById(R.id.tvSix_ID);
        sevenTv = findViewById(R.id.tvSeven_ID);
        eightTv = findViewById(R.id.tvEight_ID);
        nineTv = findViewById(R.id.tvNine_ID);
        addTv = findViewById(R.id.tvAdd_ID);
        subTv = findViewById(R.id.tvSub_ID);
        mulTv = findViewById(R.id.tvMul_ID);
        divTv = findViewById(R.id.tvDiv_ID);
        clearTv = findViewById(R.id.tvClear_ID);
        back = findViewById(R.id.tvBack_ID);
        dotTv = findViewById(R.id.tvDot_ID);
        equalTv = findViewById(R.id.tvEqual_ID);
        openTv = findViewById(R.id.tvLBrace_ID);
        closeTv = findViewById(R.id.tvRBrace_ID);
        exprTv = findViewById(R.id.tvExpression_ID);
        resultTv = findViewById(R.id.tvResult_ID);


        exprTv.setSingleLine(true);

        zeroTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!exprTv.getText().equals(""))
                    exprTv.append("0");
                    canBePressed = true;
                    canMinusPressed = true;
                    evaluateExpression();
            }
        });

        oneTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("1");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        twoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("2");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        threeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("3");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        fourTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("4");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        fiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("5");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        sixTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("6");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        sevenTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("7");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        eightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("8");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        nineTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.append("9");
                canBePressed = true;
                canMinusPressed = true;
                evaluateExpression();
            }
        });

        openTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen){
                    exprTv.append("(");
                    isOpen = false;
                }
                canBePressed = true;
                evaluateExpression();
            }
        });

        closeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isOpen){
                    exprTv.append(")");
                    isOpen = true;
                }
                canBePressed = true;
                evaluateExpression();
            }
        });

        dotTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!exprTv.getText().equals(""))
                exprTv.append(".");
                canMinusPressed = true;
                canBePressed = true;
                evaluateExpression();
            }
        });

        clearTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exprTv.setText("");
                resultTv.setText("");
                canBePressed = false;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = exprTv.getText().toString().trim();
                if(text.length() > 0)
                {
                    exprTv.setText(text.substring(0,text.length()-1));
                    evaluateExpression();
                }
            }
        });

        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!exprTv.getText().equals(""))
                    if(canBePressed)
                    {
                        exprTv.append("+");
                        canBePressed = false;
                        canMinusPressed = true;
                    }
                evaluateExpression();
            }
        });

        subTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (canMinusPressed) {

                    exprTv.append("-");
                    canMinusPressed = false;
                }
                evaluateExpression();
            }
        });

        mulTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!exprTv.getText().equals(""))
                if(canBePressed)
                {
                    exprTv.append("*");
                    canBePressed = false;
                    canMinusPressed = true;
                }
                evaluateExpression();
            }
        });

        divTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!exprTv.getText().equals(""))
                    if(canBePressed)
                    {
                        exprTv.append("/");
                        canBePressed = false;
                        canMinusPressed = true;
                    }

                evaluateExpression();
            }
        });

        equalTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                evaluateExpression();
                if(!resultTv.getText().toString().equals(""))
                {
                    exprTv.setText(resultTv.getText().toString());
                    resultTv.setText("");
                }
            }
        });
    }

    private void evaluateExpression() {

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("rhino");
        String ans;
        try {

            String getExpr = exprTv.getText().toString();
            String result = engine.eval(getExpr).toString();
            if(result.matches("[0-9]+.[0]{1}") || result.matches("\\-[0-9]+.[0]{1}")){
                ans = result.substring(0,result.length()-2);
                resultTv.setText(ans);
            }
            else{
                resultTv.setText(result);
            }

        }catch (Exception e){
            Log.d("Exception",e.getMessage());
        }
    }
}
