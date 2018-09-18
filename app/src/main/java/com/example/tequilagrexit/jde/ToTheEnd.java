package com.example.tequilagrexit.jde;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static android.widget.SeekBar.*;
import static com.example.tequilagrexit.jde.MainActivity.EXTRA_MESSAGE;
import static com.example.tequilagrexit.jde.R.string.jdeohneweg;
import static com.example.tequilagrexit.jde.jdeEntgasungsbehälter.MAX;



public class ToTheEnd extends AppCompatActivity implements NumberPicker.OnValueChangeListener, OnSeekBarChangeListener{

    static final String EBH1_SCORE = "e1Score";
    static final String EBH2_SCORE = "e2Score";
    static final String EBH3_SCORE = "e3Score";
    static final String EBH4_SCORE = "e4Score";
    static final String EBH5_SCORE = "e5Score";
    static final String REST_SCORE = "rScore";
    static final String FUEL_SCORE = "fuelScore";
    static final String ORIENT_SCORE = "oScore";
    static final String INHALT1_SCORE = "inhalt1Score";
    static final String INHALT2_SCORE = "inhalt2Score";
    static final String INHALT3_SCORE = "inhalt3Score";
    static final String INHALT4_SCORE = "inhalt4Score";
    static final String INHALT5_SCORE = "inhalt5Score";
    static final String WEIGHT_SCORE = "wScore";
    static final String WEG_SCORE = "wegScore";
    static final String BOX_SCORE= "boxScore";
    static final String IN_SCORE = "inScore";
    Boolean orient = true;
    Boolean ok = true;
    Boolean drehe_Box = false;
    Boolean gedreht;
    String fuel = "";
    String help, finaler;
    int restzahl ;
    static int inv=0;
    double weight =0; ;
    //final int WEG = 60;
   // final int KEGEL = 29;
    Button but;
    Fragment fra;
    CheckBox  checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    TextView texthelp, info, st, box, rs;
    SeekBar  seekBar1,seekBar2, seekBar3, seekBar4, seekBar5;
    jdeLinie line = new jdeLinie();
    jdeEntgasungsbehälter ebh[] = new jdeEntgasungsbehälter[MAX];
    //jdeLinie line = new jdeLinie();

    static final String[] fuellmenge = {"5.5", "5.6","5.7", "5.8", "5.9", "6.0",
            "6.1", "6.2", "6.3", "6.4", "6.5", "6.6", "6.7", "6.8", "6.9", "7.0",
            "7.1", "7.2", "7.3", "7.4", "7.5", "7.6", "7.7", "7.8",
            "7.9", "8.0", "8.1", "8.2", "8.3", "8.4", "8.5", "8.6", "8.7", "8.8",
            "8.9", "9.0", "9.1", "14.2"};
    Context totheendContext;


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putBoolean(EBH1_SCORE, ebh[0].aktiv);
        savedInstanceState.putBoolean(EBH2_SCORE, ebh[1].aktiv);
        savedInstanceState.putBoolean(EBH3_SCORE, ebh[2].aktiv);
        savedInstanceState.putBoolean(EBH4_SCORE, ebh[3].aktiv);
        savedInstanceState.putBoolean(EBH5_SCORE, ebh[4].aktiv);
        savedInstanceState.putBoolean(ORIENT_SCORE, orient);
        savedInstanceState.putInt(REST_SCORE,restzahl );
        savedInstanceState.putString(FUEL_SCORE, fuel);
        savedInstanceState.putInt(INHALT1_SCORE, ebh[0].inhalt);
        savedInstanceState.putInt(INHALT2_SCORE, ebh[1].inhalt);
        savedInstanceState.putInt(INHALT3_SCORE, ebh[2].inhalt);
        savedInstanceState.putInt(INHALT4_SCORE, ebh[3].inhalt);
        savedInstanceState.putInt(INHALT5_SCORE, ebh[4].inhalt);
        savedInstanceState.putDouble(WEIGHT_SCORE, weight);
        savedInstanceState.putBoolean(WEG_SCORE,ok );
        savedInstanceState.putBoolean(BOX_SCORE, drehe_Box);
        savedInstanceState.putInt(IN_SCORE, inv);
        super.onSaveInstanceState(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gedreht = false;
        for (int i=0; i<5;i++)
            ebh[i] = new jdeEntgasungsbehälter();
        if (savedInstanceState != null){
            ebh[0].aktiv = savedInstanceState.getBoolean(EBH1_SCORE);
            ebh[1].aktiv = savedInstanceState.getBoolean(EBH2_SCORE);
            ebh[2].aktiv = savedInstanceState.getBoolean(EBH3_SCORE);
            ebh[3].aktiv = savedInstanceState.getBoolean(EBH4_SCORE);
            ebh[4].aktiv = savedInstanceState.getBoolean(EBH5_SCORE);
            orient       = savedInstanceState.getBoolean(ORIENT_SCORE);
            restzahl     = savedInstanceState.getInt(REST_SCORE) ;
            fuel         = savedInstanceState.getString(FUEL_SCORE) ;
            ebh[0].inhalt= savedInstanceState.getInt(INHALT1_SCORE);
            ebh[1].inhalt= savedInstanceState.getInt(INHALT2_SCORE);
            ebh[2].inhalt= savedInstanceState.getInt(INHALT3_SCORE);
            ebh[3].inhalt= savedInstanceState.getInt(INHALT4_SCORE);
            ebh[4].inhalt= savedInstanceState.getInt(INHALT5_SCORE);
            weight       = savedInstanceState.getDouble(WEIGHT_SCORE);
            ok           = savedInstanceState.getBoolean(WEG_SCORE);
            drehe_Box    = savedInstanceState.getBoolean(BOX_SCORE);
            inv          = savedInstanceState.getInt(IN_SCORE);
        }
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        line = new jdeLinie(message);

        setContentView(R.layout.activity_to_the_end);
        but      = findViewById(R.id.button6);
        but.setText(R.string.jdemitweg);
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3= findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);
        seekBar4 = findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(this);
        seekBar5 = findViewById(R.id.seekBar5);
        seekBar5.setOnSeekBarChangeListener(this);
        info = findViewById(R.id.textView6);
        TextView feldtext[] = {findViewById(R.id.textView7), findViewById(R.id.textView8),
        findViewById(R.id.textView10), findViewById(R.id.textView11),
                findViewById(R.id.textView12)};

        if (!orient) {
            st = findViewById(R.id.button10);
            finaler = fuel+getResources().getString(R.string.jdegramm);
            st.setText(finaler);

            gedreht = true;

            for(int i=0; i<5; i++)
            {String text = ""+ebh[i].inhalt+"%";
                feldtext[i].setText(text) ;}

            change_weg();
            fra =getFragmentManager().findFragmentByTag("time picker");
            if (fra != null)
             showNumberPicker();


        }
        totheendContext = this;
        Toolbar myToolbar = (Toolbar) findViewById(R.id.jde_toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        help = "JDE LINIE "+message;
        TextView title = findViewById(R.id.toolbar_line);
        title.setText(help);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }


   @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
      grammzahl(numberPicker);
    }


    public void showNumberPicker(View view){
        orient = false;
        GrammPickerDialog newFragment = new GrammPickerDialog();
        newFragment.setValueChangeListener(this);
        newFragment.show(getFragmentManager(), "time picker");

    }
    public void showNumberPicker(){
        orient = false;
       GrammPickerDialog newFragment = new GrammPickerDialog();
       newFragment.setValueChangeListener(this);
       newFragment.show(getFragmentManager(), "time picker");

    }



    public void grammzahl(NumberPicker np) {

        Button button = findViewById(R.id.button10);
        float f = Float.parseFloat(fuellmenge[np.getValue()]);
        fuel = fuellmenge[np.getValue()];
        finaler = fuel+ getResources().getString(R.string.jdegramm);
        inv = np.getValue();
        button.setText(finaler);
        weight = f/1000;
        box = findViewById(R.id.textView6) ;
        box.setText("");
        berechne_Rest();



    }
    int index = 0;


    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            switch (seekBar.getId()) {

                case R.id.seekBar1:
                    index = 0;
                    texthelp = findViewById(R.id.textView7);
                    break;

                case R.id.seekBar2:
                    index = 1;
                    texthelp = findViewById(R.id.textView8);
                    break;

                case R.id.seekBar3:
                    index = 2;
                    texthelp = findViewById(R.id.textView10);
                    break;
                case R.id.seekBar4:
                    index = 3;
                    texthelp = findViewById(R.id.textView11);
                    break;
                case R.id.seekBar5:
                    index = 4;
                    texthelp = findViewById(R.id.textView12);
                    break;

        }

        ebh[index].inhalt = progress;
        ebh[index].nummer = index+1;
        if (gedreht)
            info.setText("");
        else
            info.setText("" + ebh[index].inhalt);

    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
      orient = false; gedreht = false;
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
       help =  ""+ebh[index].inhalt+"%";
       texthelp.setText(help) ;
       info.setText("") ;
       berechne_Rest();
       /* Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        Toast.makeText(this,"seek bar progress:"+message,
                Toast.LENGTH_SHORT).show();*/
    }

    public void berechne_Rest(){
        box = findViewById(R.id.textView6) ;
        box.setText("");
        int menge = 0;

        for (int i=0;(i<5 && weight>0);i++)
            if(ebh[i].aktiv){
                 if (ebh[i].inhalt==0)
                     menge = menge+((ebh[i].inhalt)*line.faktor);
                 else
                     menge = menge+(((ebh[i].inhalt)*line.faktor)+line.trichter);
                }
             //menge = (int) Math.round(menge*line.faktor);
             if (!drehe_Box) {
                 restzahl = (int) Math.round((menge / weight)) + weg(ok);
                 String h1 = ""+restzahl;
                 st = findViewById(R.id.textView5);
                 st.setText(h1);
             }else{
                 restzahl = (int) Math.round((menge / weight)) + weg(ok);
                 String h2 =  "" +Math.round(restzahl/9216)+" Boxen";
                 st = findViewById(R.id.textView5);
                 st.setText(h2);
             }

    }
    public void anzahl_Box(View view){
       orient = false;
       drehe_Box = !drehe_Box;
       berechne_Rest();
    }



    public int weg(Boolean ok){
        if (ok&&weight!=0)
            return (int)Math.round(line.strecke/weight);
        else
            return 0;
    }

    public void change_weg(View view){
        if (ok) {
            Button help = findViewById(R.id.button6);
            help.setText(jdeohneweg);

            ok = false;
        }else{
            Button help = findViewById(R.id.button6);
            help.setText(R.string.jdemitweg);

            ok = true;}
        berechne_Rest();
        orient = false;
        }

    public void change_weg(){
        if (ok) {
            Button help = findViewById(R.id.button6);
            help.setText(R.string.jdemitweg);
            berechne_Rest();

        }else{
            Button help = findViewById(R.id.button6);
            help.setText(jdeohneweg);
            berechne_Rest();
            }
    }



    public void aktivebh(View view) {
        orient = false;
        switch (view.getId()) {
            case R.id.checkBox1:
                ebh[0].aktiv = !ebh[0].aktiv;
                berechne_Rest();
                break;

            case R.id.checkBox2:
                ebh[1].aktiv = !ebh[1].aktiv;
                berechne_Rest();
                break;

            case R.id.checkBox3:
                ebh[2].aktiv = !ebh[2].aktiv;
                berechne_Rest();
                break;

            case R.id.checkBox4:
                ebh[3].aktiv = !ebh[3].aktiv;
                berechne_Rest();
                break;

            case R.id.checkBox5:
                ebh[4].aktiv = !ebh[4].aktiv;
                berechne_Rest();
                break;
        }
    }
}
