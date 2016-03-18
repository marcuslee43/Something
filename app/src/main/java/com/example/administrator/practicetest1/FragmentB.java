package com.example.administrator.practicetest1;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.awt.font.TextAttribute;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_b, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        //textView.setTextColor(Color.rgb(255,255,255));

        return view;
    }

    public void changeColor (int red, int green, int blue){

        textView.setTextColor(Color.rgb(red,green,blue));
    }

    public interface getColors {
       public void reColor(int red, int green, int blue);
    }


}
