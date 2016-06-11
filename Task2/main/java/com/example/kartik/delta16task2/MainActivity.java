package com.example.kartik.delta16task2;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private static final int SPEECH_REQUEST_CODE = 0;
    String command;
    String shape;
    String size;

    CanvasJava cj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cj = new CanvasJava(MainActivity.this);
        setContentView(cj);
        //Defaults
        shape = "rectangle";
        size = "small";

        //Setting the notification
        StringBuffer buffer = new StringBuffer();
        buffer.append("POSITION:\n\n'Up': Move the drawable up\n'Down': Move the drawable down\n'Left': Move the drawable left\n'Right': Move the drawable right\n\nSHAPE:" +
                "\n\n'Circle': Change shape of drawable to circle\n'Square': Change shape of drawable to square\n'Rectangle': Change shape of drawable to a rectangle" +
                "\n'Oval': Change the shape of the drawable to oval\n\nSIZE:\n\n'Small': Make the drawable small\n'Medium': Make the drawable medium" +
                "\n'Large': Make the drawable large\n\nPress COMMAND button to give commands");

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(buffer.toString()).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int t) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("COMMANDS");
        alert.show();
    }

        //}
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //inflate the menu. This adds options to the actionbar if it is present
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int t = item.getItemId();
        switch(t)
        {
            case R.id.speech:
                promptspeechInput();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Hey There",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }

   /* public void onButtonClick(View v) {
    if (v.getId() == R.id.imageButton) {
        promptspeechInput();
    }
}*/



    private void promptspeechInput()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        // Start the activity, the intent will be populated with the speech text
        try
        {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        }
        catch (ActivityNotFoundException a)
        {
            Toast.makeText(MainActivity.this, "Sorry, your device does not support speech language", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String speechtoText = results.get(0);
            command = speechtoText;
            // Set command as speechtoText
        }

        //Move the drawable
        moveDrawable();
        super.onActivityResult(requestCode, resultCode, i);
    }

    public void moveDrawable() {
        //setPosition sets the position, while setDrawable changes the size and shape of the drawable
        switch (command) {
            case "up":
                cj.setPosition(0, -10);
                break;
            case "down":
                cj.setPosition(0, 10);
                break;
            case "left":
                cj.setPosition(-10, 0);
                break;
            case "right":
                cj.setPosition(10, 0);
                break;
            case "small":
                size = "small";
                cj.setDrawable(shape, size);
                break;
            case "medium":
                size = "medium";
                cj.setDrawable(shape, size);
                break;
            case "large":
                size = "large";
                cj.setDrawable(shape, size);
                break;
            case "square":
                shape = "square";
                cj.setDrawable(shape, size);
                break;
            case "rectangle":
                shape = "rect";
                cj.setDrawable(shape, size);
                break;
            case "circle":
                shape = "circle";
                cj.setDrawable(shape, size);
                break;
            case "oval":
                shape = "oval";
                cj.setDrawable(shape, size);
                break;
            default:
                Toast.makeText(MainActivity.this, "Check the command you gave", Toast.LENGTH_SHORT).show();
        }
    }

}
