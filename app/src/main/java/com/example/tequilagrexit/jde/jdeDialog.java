package com.example.tequilagrexit.jde;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class jdeDialog  {

    static int mhdialog(int index) {

        final CharSequence[] items = {"330", "360", "420", "540", "244"};

        String help = items[index].toString();
        return Integer.parseInt(help);
    }
    static String formatdialog(int findex){
        final CharSequence[] fitems = {"EUROPA", "KHC", "PRO"};
        return fitems[findex].toString();
       // return help;
    }
}