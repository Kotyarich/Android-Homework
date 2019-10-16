package com.example.list;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.list.content.Content;
import com.example.list.content.Content.ListItem;

public class ListFragment extends Fragment {

    private static final int PORTRAIT_COL_NUMBER = 3;
    private static final int LANDSCAPE_COL_NUMBER = 4;

    private MyItemRecyclerViewAdapter adapter;
    private OnListFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list_view);
        Context context = view.getContext();
        int columnCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ?
                PORTRAIT_COL_NUMBER : LANDSCAPE_COL_NUMBER;
        recyclerView.setLayoutManager(new GridLayoutManager(context, columnCount));
        adapter = new MyItemRecyclerViewAdapter(Content.ITEMS, mListener);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void addItem() {
        int size = adapter.getItemCount();
        Content.addItem(Content.createListItem(size + 1));
        adapter.notifyItemChanged(size);
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ListItem item);
    }
}
