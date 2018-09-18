package com.example.tequilagrexit.jde;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tequilagrexit.jde.R.*;


public class jdeFabo extends PairOfLines{
    private Context fcontext;

    static void  mhdtoFabo(Context pairoflines){

        Button buttonw =  ((Activity) pairoflines).findViewById(id.button9);

        buttonw.setText(string.jdefabo);
       // buttonw.setBackgroundResource(R.color.jdeRed);
        buttonw.setEnabled(false);

    }
    static void formattoFabo(Context pairoflines) {

        Button buttonw = ((Activity) pairoflines).findViewById(id.button8);

        buttonw.setText(string.jdefabo);
       // buttonw.setBackgroundResource(R.color.jdeRed);
        buttonw.setEnabled(false);
    }
    static void aktiviereFabo(Context pairoflines) {

        Button buttonw =  ((Activity) pairoflines).findViewById(id.button5);
        buttonw.setEnabled(false);
       // buttonw.setBackgroundResource(R.color.jdeGreen);

    }
    static void linetoFabo(Context pairoflines) {

        Button buttonw = ((Activity) pairoflines).findViewById(id.button7);
        buttonw.setEnabled(false);
        buttonw.setText(string.jdefabo);
       // buttonw.setBackgroundResource(R.color.jdeRed);

    }

    static void ftof(Context fabo){
        Button mhd = ((Activity) fabo).findViewById(id.button8);
        mhd.setEnabled(false);
    }
    static void ltof(Context fabo){
        Button mhd = ((Activity) fabo).findViewById(id.button7);
        mhd.setEnabled(false);
    }
    static void fabtof(Context fabo ){

    }
    static void mtof(Context fabo){

      Button mhd = ((Activity) fabo).findViewById(id.button9);
      mhd.setEnabled(false);
    }
    static void ttof(Context fabo){
        TextView t = ((Activity) fabo).findViewById(id.textView);
        t.setEnabled(false);
    }
}
