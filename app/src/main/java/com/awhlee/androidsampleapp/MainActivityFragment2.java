package com.awhlee.androidsampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment2 extends Fragment {
    TextView mTextView;

    public MainActivityFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_main2, container, false);
        mTextView = (TextView)returnValue.findViewById(R.id.fragment_text2);
        mTextView.setText("MainActivityFragment2");
        return returnValue;
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}


