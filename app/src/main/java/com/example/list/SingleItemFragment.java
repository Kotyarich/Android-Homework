package com.example.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class SingleItemFragment extends Fragment {
    private static final String ARG_TEXT = "text_value";

    private String text;

    public SingleItemFragment() {
    }

    static SingleItemFragment newInstance(String text) {
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
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = v.findViewById(R.id.frgmText);
        textView.setText(text);
        int color = Integer.parseInt(text) % 2 == 0 ? R.color.colorEven : R.color.colorOdd;
        textView.setTextColor(ContextCompat.getColor(inflater.getContext(), color));
        return v;
    }
}
