package com.example.administrator.practicetest1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SeekActivity extends AppCompatActivity implements FragmentB.getColors {
int r, g, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        SharedPreferences preferences = getSharedPreferences("SaveColors", MODE_PRIVATE);
        //editText.setText(preferences.getString("username", ""));
        r=preferences.getInt("red",r);
        g=preferences.getInt("green",g);
        b=preferences.getInt("blue",b);

        fragmentB.changeColor(r, g, b);


    }

    @Override
    public void reColor(int red, int green, int blue) {
        saveColors(red,green,blue);
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
        fragmentB.changeColor(red, green, blue);
    }


    private void saveColors(int a, int b, int c){

        SharedPreferences preferences = getSharedPreferences("SaveColors", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //editor.putString("username",editText.getText().toString());
        editor.putInt("red",a);
        editor.putInt("green",b);
        editor.putInt("blue",c);
        editor.apply();
    }


}
