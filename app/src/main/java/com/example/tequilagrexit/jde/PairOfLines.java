package com.example.tequilagrexit.jde;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tequilagrexit.jde.MainActivity.EXTRA_MESSAGE;


public class PairOfLines extends AppCompatActivity {
    static final String INDEX_SCORE = "indexScore";
    static final String FINDEX_SCORE = "findexScore";
    static final String FORMAT_SCORE = "formatScore";
    static final String WAHL_SCORE = "wahlScore";
    static final String DONE_SCORE = "doneScore";
    static final String FDONE_SCORE = "fdoneScore";
    static final String FABO = "FABO";
    Context pairoflinesContext;

     //final String ort = "LXB";
     String format = "EUROPA";
     int findex = 0;
     int wahl = 330;
     int index = 0;
     Boolean done = false;
     Boolean fdone = false;
     Boolean pause = false;
     int owert;
     //Intent intent = getIntent();
    // String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {


        // Save the state of item position
        savedInstanceState.putInt(INDEX_SCORE,index);
        savedInstanceState.putInt(FINDEX_SCORE,findex);
        savedInstanceState.putInt(WAHL_SCORE,wahl);
        savedInstanceState.putString(FORMAT_SCORE,format);
        savedInstanceState.putBoolean(DONE_SCORE,done);
        savedInstanceState.putBoolean(FDONE_SCORE,fdone);
        //savedInstanceState.putString(MainActivity.EXTRA_MESSAGE,message );
        super.onSaveInstanceState(savedInstanceState);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            index = savedInstanceState.getInt(INDEX_SCORE);
            findex = savedInstanceState.getInt(FINDEX_SCORE);
            wahl = savedInstanceState.getInt(WAHL_SCORE);
            format = savedInstanceState.getString(FORMAT_SCORE);
            done = savedInstanceState.getBoolean(DONE_SCORE);
            fdone = savedInstanceState.getBoolean(FDONE_SCORE);
            //message = savedInstanceState.getString(MainActivity.EXTRA_MESSAGE);
        }
        Activity activity = PairOfLines.this;
        owert = activity.getResources().getConfiguration().orientation;
        setContentView(R.layout.activity_pair_of_lines);
        pairoflinesContext = this;
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        if (( index != 0) || (done )){
            Button button = findViewById(R.id.button9);
            button.setText(""+wahl);
            done = true;
            //fdone = true;
            //zeigemhd();
        }
        if (( findex != 0) || (fdone )) {
            Button button = findViewById(R.id.button8);
            button.setText(format);
            fdone = true;
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
       // done = true;

        zeigemhd();
        zeigelot();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.jde_toolbar);
        setSupportActionBar(myToolbar);
        // myToolbar.setTitle(R.string.app_name);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView title = findViewById(R.id.toolbar_line);
        String help = "JDE LINIE "+message;
        title.setText(help);
        getSupportActionBar().setHomeButtonEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });


    }



      public void dialog(View view) {

          wahl = jdeDialog.mhdialog(index);
          if (index<4)
          {index++;}
          else {index = 0;}
            Button button = findViewById(R.id.button9);
            button.setText(""+wahl);
          zeigemhd();
          done = true;
      }
      public void format(View view){
          format = jdeDialog.formatdialog(findex);
          if (findex<2)
          {findex++;}
          else {findex = 0;}
          Button button = findViewById(R.id.button8);
          button.setText(format);
          zeigemhd();
          fdone = true;
      }
      public void modi(View view) {
          jdeFabo.mhdtoFabo(pairoflinesContext);
          jdeFabo.formattoFabo(pairoflinesContext);
          jdeFabo.aktiviereFabo(pairoflinesContext);
          jdeFabo.linetoFabo(pairoflinesContext);
          //Button button = findViewById(R.id.button5);

          wahl = 5;
          done = true;
          fdone = true;

          format = "EUROPA";
          zeigemhd();
          zeigelot();


      }
    public void fabo(View view) {

        Intent mintent = getIntent();
        String message = mintent.getStringExtra(EXTRA_MESSAGE);

        Intent intent = new Intent(this, FaboActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
      public void linechange(View view){
          Intent intent = getIntent();
          String message = intent.getStringExtra(EXTRA_MESSAGE);
          int help = Integer.parseInt(message);
          String newline = jdechangeline.changeline(help, pairoflinesContext);


          intent.putExtra(EXTRA_MESSAGE, newline);
          TextView title = findViewById(R.id.toolbar_line);
          String h2 = "JDE LINIE "+newline;
          title.setText(h2);
          zeigelot();
      }
      public void zeigemhd() {
          String message = jdeDatum.mhdDat(owert,wahl,format);
          TextView textView = findViewById(R.id.textView2);
          textView.setText(message);
      }
      public void zeigelot() {
          Intent intent = getIntent();
          String message = getString(R.string.jdeort)+intent.getStringExtra(EXTRA_MESSAGE)+jdeDatum.lotDat();
          TextView textView = findViewById(R.id.textView3);
          textView.setText(message);
      }
      public void toend(View view){

          Intent mintent = getIntent();
          String message = mintent.getStringExtra(EXTRA_MESSAGE);
          Intent intent = new Intent(this, ToTheEnd.class);
          intent.putExtra(EXTRA_MESSAGE, message);
          startActivity(intent);
      }

}