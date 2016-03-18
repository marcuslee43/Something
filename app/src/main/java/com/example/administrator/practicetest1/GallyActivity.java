package com.example.administrator.practicetest1;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GallyActivity extends AppCompatActivity {
    ImageView imageView;
    int currentIndex;
    List<Integer> myImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gally);
        imageView = (ImageView) findViewById(R.id.imageView5);
        myImages= Arrays.asList(R.drawable.show4,R.drawable.show5,
                R.drawable.show6,R.drawable.show7);
        SharedPreferences preferences = getSharedPreferences("CurPic", MODE_PRIVATE);
        //editText.setText(preferences.getString("username", ""));
        currentIndex=preferences.getInt("CurPic",currentIndex);
        imageView.setImageResource(myImages.get(currentIndex));
    }

    private void savePicSate(int currentIndex) {
        SharedPreferences preferences = getSharedPreferences("CurPic", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        //editor.putString("username",editText.getText().toString());
        editor.putInt("CurPic",currentIndex);
        editor.apply();
    }

    public void up(View view) {

        currentIndex++;
        if(currentIndex>3)currentIndex=0;
        savePicSate(currentIndex);
        imageView.setImageResource(myImages.get(currentIndex));
    }

    public void back(View view) {

        currentIndex--;
        if(currentIndex<0)currentIndex=3;
        savePicSate(currentIndex);
        imageView.setImageResource(myImages.get(currentIndex));
    }

    public void fourImg(View view) {
        imageView.setImageResource(R.drawable.show7);
        currentIndex=3;
        savePicSate(currentIndex);
    }

    public void thiImg(View view) {
        imageView.setImageResource(R.drawable.show6);
        currentIndex=2;
        savePicSate(currentIndex);
    }

    public void secImg(View view) {
        imageView.setImageResource(R.drawable.show5);
        currentIndex=1;
        savePicSate(currentIndex);
    }

    public void firstImg(View view) {
        imageView.setImageResource(R.drawable.show4);
        currentIndex=0;
        savePicSate(currentIndex);
    }


}
