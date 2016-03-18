package com.example.administrator.practicetest1;


import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.style.UpdateAppearance;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentT extends Fragment {
    SeekBar seekBar, seekBar2, seekBar3;
    int r,g,b;
    int re, gr, bl;
    FragmentB.getColors getColors;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_t, container, false);

        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) view.findViewById(R.id.seekBar3);

        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBar3.setOnSeekBarChangeListener(seekBarChangeListener);

        return view;
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener= new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updatText();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void updatText(){
        r=seekBar.getProgress();
        g=seekBar2.getProgress();
        b=seekBar3.getProgress();

        //getColors= (FragmentB.getColors) getActivity();
        getColors= (SeekActivity) getActivity();
        getColors.reColor(r,g,b);

    }

    @Override
    public void onResume() {
        super.onResume();
        SeekActivity seekActivity= (SeekActivity) getActivity();
        re=seekActivity.r;
        gr=seekActivity.g;
        bl=seekActivity.b;
        seekBar.setProgress(re);
        seekBar2.setProgress(gr);
        seekBar3.setProgress(bl);

    }
}
