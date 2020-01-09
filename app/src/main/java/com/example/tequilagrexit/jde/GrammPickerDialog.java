package com.example.tequilagrexit.jde;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;



public class GrammPickerDialog extends DialogFragment {
    private NumberPicker.OnValueChangeListener valueChangeListener;
    static final String TEST1_SCORE = "t1Score";
    int t1;
     //static final String OUT_SCORE = "outScore";
   // Activity activity = getActivity();
    // 09.01.2020


     @Override
     public void onStart() {
         super.onStart();
         if (getDialog() == null) {
             return;
         }

         int dialogWidth = 600;
         int dialogHeight = 700;
         getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
        // getDialog().setTitle(getString(R.string.recipe_dialog_title));
     }
    /* @Override
     public void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
       // setRetainInstance(true);

     }*/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TEST1_SCORE, t1);
        super.onSaveInstanceState(savedInstanceState);
        // setRetainInstance(true);
    }


        @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         return super.onCreateView(inflater, container, savedInstanceState);

      //if (savedInstanceState != null) {

        // if (valueChangeListener == null)





     }

     @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       setRetainInstance(true);
        //if (savedInstanceState != null)
         //  this.valueChangeListener = getValueChangeListener();

        final NumberPicker numberPicker = new NumberPicker(getActivity());
        t1 = 1;
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(ToTheEnd.fuellmenge.length-1);
        numberPicker.setDisplayedValues(ToTheEnd.fuellmenge);
       //numberPicker.setOnValueChangedListener(valueChangeListener);
        numberPicker.setValue(ToTheEnd.inv);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Füllmenge");
        builder.setMessage("Auswählen:");

         //AlertDialog.Builder button
         //t1 = numberPicker.getValue();
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueChangeListener.onValueChange(numberPicker,
                        numberPicker.getValue(), numberPicker.getValue());

            }
        });

         builder.setNegativeButton("ZURÜCK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 //valueChangeListener.onValueChange(numberPicker,
                   //numberPicker.getValue(), numberPicker.getValue());
                // Toast.makeText(this, "seek bar progress:",
                  //       Toast.LENGTH_SHORT).show();
             }
         }).setView(numberPicker);


         return builder.create();
    }

    public NumberPicker.OnValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }



 }

