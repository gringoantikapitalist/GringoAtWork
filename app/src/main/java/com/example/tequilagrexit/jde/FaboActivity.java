package com.example.tequilagrexit.jde;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tequilagrexit.jde.R.layout;

public  class FaboActivity extends AppCompatActivity {

   Context faboContext;


    public Button buttonfab;
    public TextView linie;
    public TextView mhd;
    public TextView lot;
    int owert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_pair_of_lines);
        faboContext = this;
        jdeFabo.mtof(faboContext);
        jdeFabo.ftof(faboContext);
        jdeFabo.ltof(faboContext);
        jdeFabo.ttof(faboContext);
        buttonfab = findViewById(R.id.button5);
        jdeFabo.fabtof(faboContext);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        linie = findViewById(R.id.textView);
        linie.setText(message);
        Activity activity = FaboActivity.this;
        owert = activity.getResources().getConfiguration().orientation;
        String fmhd = jdeDatum.mhdDat(owert, 7, "EUROPA");
        mhd = findViewById(R.id.textView2);
        mhd.setText(fmhd);
        String flot = getString(R.string.jdeort)+intent.getStringExtra(MainActivity.EXTRA_MESSAGE)+jdeDatum.lotDat();
        lot = findViewById(R.id.textView3);
        lot.setText(flot);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        TextView title = findViewById(R.id.toolbar_line);
        String help = "JDE LINIE "+message;
        title.setText(help);



        buttonfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

