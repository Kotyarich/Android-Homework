package com.example.list;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.list.content.Content;


public class MainActivity extends AppCompatActivity
        implements ListFragment.OnListFragmentInteractionListener {

    private static final String SAVED_STATE = "state";
    private static final String LIST_STATE = "list";
    private static final String SINGLE_NUM_STATE = "single";

    private String curr_state = LIST_STATE;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            curr_state = savedInstanceState.getString(SAVED_STATE);
        }

        if (curr_state.equals(LIST_STATE)) {
            FragmentManager manager = getSupportFragmentManager();
            fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.replace(R.id.frgmCont, new ListFragment());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        curr_state = LIST_STATE;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_STATE, curr_state);
    }

    @Override
    public void onListFragmentInteraction(Content.ListItem item) {
        FragmentManager manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        SingleItemFragment fragment = SingleItemFragment.newInstance(item.content);
        fragmentTransaction.replace(R.id.frgmCont, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        curr_state = SINGLE_NUM_STATE;
    }

    public void onAddButtonClick(View view) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.frgmCont);
        fragment.addItem();
    }
}
