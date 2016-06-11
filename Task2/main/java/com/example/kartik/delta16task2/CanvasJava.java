package com.example.kartik.delta16task2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

public class CanvasJava extends View {

    Bitmap myImage;
    int x ,y, a, b;

    Canvas can;

    // Constructor for the view
    public CanvasJava(Context context){
        super(context);
        myImage = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_rect);
        x = 0;
        y = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        can = canvas;

        // Move right
        if(a > 0){
            if(x < x + a){
                x++;
                a--;
            } else{
                a = 0;
            }
            // Wrap around right
            if(x + myImage.getWidth() > canvas.getWidth()){
                x = 0;
            }
        }
        // Move left
        else if(a < 0){
            if(x > x + a){
                x--;
                a++;
            } else{
                a = 0;
            }
            // Wrap around left
            if(x < 0){
                x = canvas.getWidth() - myImage.getWidth();
            }
        }
        // Move down
        if(b > 0){
            if(y < y + b){
                y++;
                b--;
            } else{
                b = 0;
            }
            // Wrap around bottom
            if(y + myImage.getHeight() > canvas.getHeight()){
                y = 0;
            }
        }
        // Move up
        else if (b < 0){
            if(y > y + b){
                y--;
                b++;
            } else {
                b = 0;
            }
            // Wrap around top
            if(y < 0){
                y = canvas.getHeight() - myImage.getHeight();
            }
        }

        Paint paint = new Paint();
        canvas.drawBitmap(myImage, x, y, paint);
        invalidate();
    }
    public void setPosition(int x, int y){
        a = x;
        b = y;
    }
    public void setDrawable(String shape, String size){
        // Square shape
        if(shape.equals("square")){
            myImage = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_rect);

            // Small size
            if(size.equals("small")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 90) / width;
                float scaleHeight = ((float) 90) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Medium size square
            else if(size.equals("medium")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 180) / width;
                float scaleHeight = ((float) 180) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Large size square
            else if(size.equals("large")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
        }
        //Rectangle shape
        else if(shape.equals("rect")){
            myImage = BitmapFactory.decodeResource(getResources(), R.mipmap.blue_rect);
            //Small size rectangle
            if(size.equals("small")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 180) / width;
                float scaleHeight = ((float) 90) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Medium size rectangle
            else if(size.equals("medium")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 360) / width;
                float scaleHeight = ((float) 180) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //large size rectangle
            else if(size.equals("large")){
                int width = myImage.getWidth();
                int height =myImage.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()/2) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
        }
        //Circle
        else if(shape.equals("circle")){
            myImage = BitmapFactory.decodeResource(getResources(),R.mipmap.blue_circle);
            //Small size circle
            if(size.equals("small")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 90) / width;
                float scaleHeight = ((float) 90) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Medium size circle
            else if(size.equals("medium")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 180) / width;
                float scaleHeight = ((float) 180) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //large size circle
            else if(size.equals("large")){
                int width = myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
        }

        //Oval coding
        else if(shape.equals("oval")){
            myImage = BitmapFactory.decodeResource(getResources(),R.mipmap.blue_circle);
            //Small size oval
            if(size.equals("small")){
                int width = myImage.getWidth();
                int height =myImage.getHeight();
                float scaleWidth = ((float) 180) / width;
                float scaleHeight = ((float) 90) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Medium size oval
            else if(size.equals("medium")){
                int width =myImage.getWidth();
                int height = myImage.getHeight();
                float scaleWidth = ((float) 360) / width;
                float scaleHeight = ((float) 180) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
            //Large size oval
            else if(size.equals("large")){
                int width = myImage.getWidth();
                int height =myImage.getHeight();
                float scaleWidth = ((float) can.getWidth()) / width;
                float scaleHeight = ((float) can.getWidth()/2) / height;

                // Create a matrix for resizing
                Matrix matrix = new Matrix();

                // Resizing the Bitmap
                matrix.postScale(scaleWidth, scaleHeight);

                // Creating the new Bitmap
                Bitmap newBitmap = Bitmap.createBitmap(myImage, 0, 0, width, height, matrix, false);
                myImage.recycle();
                myImage = newBitmap;
            }
        }
        //Check overflow on shape change
        if(x + myImage.getWidth() > can.getWidth()){
            x = 0;
        }
        if(y + myImage.getHeight() > can.getHeight()){
            y = 0;
        }
    }
}

