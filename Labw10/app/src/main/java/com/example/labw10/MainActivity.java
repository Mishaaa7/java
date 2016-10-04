package com.example.labw10;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener {
    Paint p;
    int mywidth=0, myheight=0;
    int side = 0;
    int row = 0;
    int count = 0;
    float x, y;
    String koord = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mm=new misha(this);
        setContentView(mm);
        mm.setOnTouchListener(this);
    }
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                koord = "x: " + x + " y:" + y + " число нажатий:" + ++count;
                mm.invalidate();
                break;
        }
        return true;
    }

    class misha extends View {
        public misha(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            if (mywidth < myheight) side = mywidth/8;
            else side = myheight/8;
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            p.setColor(Color.RED);
            for (int j = 0; j < 8; j++) {
                row = j*side;
                if(p.getColor()== Color.WHITE) p.setColor(Color.BLACK);
                else p.setColor(Color.WHITE);
                for (int i = 0; i < 8; i++) {
                    if(p.getColor()== Color.WHITE) p.setColor(Color.BLACK);
                    else p.setColor(Color.WHITE);
                    canvas.drawRect(i * side, row, i * side + side, row + side, p);
                }
            }
            p.setColor(Color.BLACK);
            p.setTextSize(20);
            if (koord != "") {
                canvas.drawText(koord, 0, side*9, p);
                return;
            }
            canvas.drawText(("screen size:" + mywidth + "  " + myheight), 0, side*9, p);
        }
    }
    misha mm;
}
