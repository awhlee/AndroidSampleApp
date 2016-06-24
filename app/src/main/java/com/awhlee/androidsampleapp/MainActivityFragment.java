package com.awhlee.androidsampleapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    TextView mTextView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View returnValue = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView = (TextView)returnValue.findViewById(R.id.fragment_text);
        mTextView.setText("MainActivityFragment1");
        return returnValue;
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}


