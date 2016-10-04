package com.example.labw5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView label;
    private Button changeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.text);
        changeText = (Button) findViewById(R.id.changeText);
        changeText.setOnClickListener(obrabotka);
    }
    View.OnClickListener obrabotka = new View.OnClickListener() {

        public void onClick(View v) {

            label.setText("Кнопка была нажата!");

        }

    };
}
