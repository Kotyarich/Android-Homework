package com.example.list;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SingleItemFragment extends Fragment {
    private static final String ARG_TEXT = "text_value";

    private String text;

    public SingleItemFragment() {
    }

    public static SingleItemFragment newInstance(String text) {
        SingleItemFragment fragment = new SingleItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView view = getView().findViewById(R.id.frgmText);
        if (view != null) {
            view.setText(text);
            Context context = getContext();
            int color = Integer.parseInt(text) % 2 == 0? R.color.colorEven : R.color.colorOdd;
            view.setTextColor(ContextCompat.getColor(context, color));
        }
    }
}
