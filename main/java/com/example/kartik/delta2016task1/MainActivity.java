package com.example.kartik.delta2016task1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int color;
    public static final String PREFS_NAME = "Kartik";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!= null){
            count = savedInstanceState.getInt("count");
            color = savedInstanceState.getInt("color");

            TextView text = (TextView)findViewById(R.id.textView);
            text.setText("Button has been clicked "+count+" times");

            final View view;
            view = (RelativeLayout) findViewById(R.id.Relative_Layout);

            view.setBackgroundColor(color);
        }

        final View view;
        view = (RelativeLayout) findViewById(R.id.Relative_Layout);

        final TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Button has been clicked " + count + " times");

        Button increment = (Button) findViewById(R.id.button);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                text.setText("Button has been clicked "+count+" times");
                GenerateRandomBgColors(view);

            }
        });

        ((Button) findViewById(R.id.reset)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText(Integer.toString(0));
                 = 0;
            }
        });

        SharedPreferences sharedPref = getSharedPreferences("Reset", Context.MODE_PRIVATE);
        count = sharedPref.getInt("count",0);
        color = sharedPref.getInt("color",0);
        ((TextView) findViewById(R.id.textView)).setText(Integer.toString(count));
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        //super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putInt("color", color);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("Reset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("count", count);
        editor.putInt("color", color);
        editor.apply();
    }

    private void GenerateRandomBgColors(View view){
        Random rnd = new Random();
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color);
    }


}


