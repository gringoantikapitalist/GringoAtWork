package com.example.tequilagrexit.jde;


import android.content.Context;
import android.widget.SeekBar;
import android.widget.TextView;


public class jdeEntgasungsbehälter {
    final static int MAX = 5;
    int inhalt;
    int nummer;
    Boolean aktiv ;
    jdeEntgasungsbehälter() {
        inhalt=0;
        nummer=1;
        aktiv = false;
    }

  /* public class behalterfullen implements SeekBar.OnSeekBarChangeListener{

        TextView texthelp, info;
       //SeekBar seekbar = new SeekBar();


       @Override
            public void onProgressChanged (SeekBar seekBar,int progress, boolean fromUser){

                switch (seekBar().getId()) {

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
                ebh[index] = new jdeEntgasungsbehälter();
                ebh[index].inhalt = progress;

                info.setText("" + ebh[index].inhalt);

            }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            texthelp.setText(""+ebh[index].inhalt+"%") ;
            info.setText("") ;
        }
    }*/
}
