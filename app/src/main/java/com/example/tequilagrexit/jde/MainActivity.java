package com.example.tequilagrexit.jde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tequilagrexit.jde.MESSAGE";
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_toolbar();





    }
    public void init_toolbar(){

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
       // myToolbar.setTitle(R.string.app_name);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        TextView title = findViewById(R.id.toolbar_line);
        title.setText(R.string.app_name);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void zeigeWahl(View view) {

        Intent intent = new Intent(this, PairOfLines.class);
        String message = "";
        switch (view.getId()) {
            case R.id.button:
                message = "22";
            break;

            case R.id.button2:
                message = "24";
                break;

            case R.id.button3:
                message = "26";
                break;

            case R.id.button4:
                message = "28";
                break;

        }
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);

    }



}
