package com.example.kartik.delta16task1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    int count;
    int color;
    public static final String PREFS_NAME = "Kartik";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState!=null)      // Checks if the app is opened for the first time
        {
            color = savedInstanceState.getInt("color");
            count = savedInstanceState.getInt("count");

            TextView text = (TextView) findViewById(R.id.textView);
            text.setText("You have clicked the button "+(Integer.toString(count))+" times");

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            if (width < height)          // Checks whether orientation is portrait or landscape
            {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Relative_Layout);
                relativeLayout.setBackgroundColor(color);
            }
            else
            {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear_Layout);
                linearLayout.setBackgroundColor(color);
            }

        }

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String string ;
                TextView text = (TextView) findViewById(R.id.textView);
                count++;
                string = "You have clicked the button "+Integer.toString(count)+ " times";
                text.setText(string);


                Random rnd = new Random();      // Generating random background color
                color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));


                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int height = displaymetrics.heightPixels;
                int width = displaymetrics.widthPixels;

                if (width < height)
                {
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Relative_Layout);
                    relativeLayout.setBackgroundColor(color);
                }
                else
                {
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear_Layout);
                    linearLayout.setBackgroundColor(color);
                }
            }
        });


        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView text = (TextView) findViewById(R.id.textView);
                text.setText("You have clicked the button "+(Integer.toString(0))+" times");
                count = 0;
                color =  Color.argb(255, 63, 249, 7);         // Default color for the app

                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int height = displaymetrics.heightPixels;
                int width = displaymetrics.widthPixels;

                if (width < height)
                {
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Relative_Layout);
                    relativeLayout.setBackgroundColor(color);
                }
                else
                {
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear_Layout);
                    linearLayout.setBackgroundColor(color);
                }

            }
        });


        SharedPreferences sharedPref = getSharedPreferences("Kartik",Context.MODE_PRIVATE);
        count = sharedPref.getInt("count",count);
        color = sharedPref.getInt("color",color);
        ((TextView) findViewById(R.id.textView)).setText("You have clicked the button "+(Integer.toString(count))+" times");

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        if (width < height)
        {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Relative_Layout);
            relativeLayout.setBackgroundColor(color);
        }
        else
        {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear_Layout);
            linearLayout.setBackgroundColor(color);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)     // To save the state while changing the orientation
    {
        outState.putInt("count", count);
        outState.putInt("color", color);
    }


    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("Kartik",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("count", count);
        editor.putInt("color", color);
        editor.apply();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}