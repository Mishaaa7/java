package com.example.labw11;

import android.content.Context;
import android.graphics.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Paint p;
    Bitmap oleg;
    int bmpx = 0, bmpy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oleg = BitmapFactory.decodeResource(getResources(), 0x7f02004b);
        bmpx=oleg.getWidth();
        bmpy=oleg.getHeight();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mm=new misha(this);
        setContentView(mm);
    }

    class misha extends View {
        public misha(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(oleg, new Rect(235,0,465,350), new Rect(50,50,430,628), p);
            canvas.drawBitmap(oleg, new Rect(150,440,300,600), new Rect(0,160,240,400), p);
        }
    }
    misha mm;

}
