package com.example.tequilagrexit.jde;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class jdechangeline {

    public static String changeline(int linie, Context pairoflines){
        if (linie%2 == 0) {
            linie ++;
            TextView changetext =   ((Activity)pairoflines).findViewById(R.id.textView);
            changetext.setText("" +linie );

        }
        else {
            linie --;
            TextView changetext =   ((Activity)pairoflines).findViewById(R.id.textView);
            changetext.setText("" +linie);
        }
        return ""+linie;
    }
}
