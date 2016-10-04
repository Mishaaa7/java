package com.example.labw8;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {

    TextView position;
    float x, y;
    String sDown, sMove, sUp;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = new TextView(this);
        position.setOnTouchListener(this);
        setContentView(position);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                sDown = "Down: " + x + "," + y;
                sMove = ""; sUp = "";
                break;
            case MotionEvent.ACTION_MOVE: // движение
                sMove = "Move: " + x + "," + y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                break;
        }
        position.setText(sDown + "\n" + sMove + "\n" + sUp);
        return true;
    }
}