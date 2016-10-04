package com.example.labw6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button clearText, sum, minus, delenie, umnojenie, mod, xor, binary, result, btn;
    private EditText x, y, textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum = (Button) findViewById(R.id.sum);
        minus = (Button) findViewById(R.id.minus);
        delenie = (Button) findViewById(R.id.delenie);
        umnojenie = (Button) findViewById(R.id.umnojenie);
        mod = (Button) findViewById(R.id.mod);
        xor = (Button) findViewById(R.id.xor);
        binary = (Button) findViewById(R.id.binary);
        result = (Button) findViewById(R.id.result);
        clearText = (Button) findViewById(R.id.clearText);

        x = (EditText) findViewById(R.id.x);
        y = (EditText) findViewById(R.id.y);
        textResult = (EditText) findViewById(R.id.textResult);
        sum.setOnClickListener(znak);
        minus.setOnClickListener(znak);
        delenie.setOnClickListener(znak);
        umnojenie.setOnClickListener(znak);
        mod.setOnClickListener(znak);
        xor.setOnClickListener(znak);
        binary.setOnClickListener(znak);
        result.setOnClickListener(obrabotka);
        clearText.setOnClickListener(clear);
    }
    OnClickListener znak = new OnClickListener() {
        public void onClick(View v) {
            btn = (Button) findViewById(v.getId());
        }

    };
    OnClickListener clear = new OnClickListener() {
            public void onClick(View v) {
                textResult.setText("");
                x.setText("");
                y.setText("");
                btn = null;
            }

    };


    OnClickListener obrabotka = new OnClickListener() {
        public void onClick(View v) {
            int num1 = 0;
            int num2 = 0;
            if (TextUtils.isEmpty(x.getText().toString()) || TextUtils.isEmpty(y.getText().toString()) || btn == null) return;
            num1 = Integer.parseInt(x.getText().toString());
            num2 = Integer.parseInt(y.getText().toString());

            switch (btn.getId()) {
                case R.id.sum:
                    textResult.setText(num1 + num2 + " ");
                    break;
                case R.id.minus:
                    textResult.setText(num1 - num2 + " ");
                    break;
                case R.id.delenie:
                    textResult.setText(num1 / num2 + " ");
                    break;
                case R.id.umnojenie:
                    textResult.setText(num1 * num2 + " ");
                    break;
                case R.id.mod:
                    textResult.setText(num1 % num2 + " ");
                    break;
                case R.id.xor:
                    textResult.setText((num1^num2) + " ");
                    break;
                case R.id.binary:
                    textResult.setText(Integer.toBinaryString(num1) + " ");
                    break;
                default:
                    break;
            }
        }

    };

}
