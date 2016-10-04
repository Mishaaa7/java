package com.example.labw7;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

import static android.R.attr.max;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private double[] arrNow = new double[3];
    TextView xmax, zmax, ymax, xnow, znow, ynow;
    Button button;
    SensorManager misha;
    Sensor sasha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        misha = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sasha=misha.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        xmax = (TextView) findViewById(R.id.xmax);
        xnow = (TextView) findViewById(R.id.xnow);
        zmax = (TextView) findViewById(R.id.zmax);
        znow = (TextView) findViewById(R.id.znow);
        ymax = (TextView) findViewById(R.id.ymax);
        ynow = (TextView) findViewById(R.id.ynow);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(maxDelete);
    }
    @Override

    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
// Do something here if sensor accuracy changes.
    }
    public View.OnClickListener maxDelete = new View.OnClickListener() {
        public void onClick(View v) {
            xmax.setText("");
            ymax.setText("");
            zmax.setText("");
        }
    };
    @Override
    public final void onSensorChanged(SensorEvent event) {
        xnow.setText("" + event.values[0]);
        ynow.setText("" + event.values[1]);
        znow.setText("" + event.values[2]);
        if (xmax.getText()=="") {
            xmax.setText("" + event.values[0]);
            ymax.setText("" + event.values[1]);
            zmax.setText("" + event.values[2]);
        }
        if ((Float.parseFloat(xmax.getText().toString())) < event.values[0]) xmax.setText("" + event.values[0]);
        if ((Float.parseFloat(ymax.getText().toString())) < event.values[1]) ymax.setText("" + event.values[1]);
        if ((Float.parseFloat(zmax.getText().toString())) < event.values[2]) zmax.setText("" + event.values[2]);
    }
    protected void onResume() {
        super.onResume();
        misha.registerListener(this, sasha, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
