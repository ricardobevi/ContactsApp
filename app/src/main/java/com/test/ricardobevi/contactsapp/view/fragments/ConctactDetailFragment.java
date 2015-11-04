package com.test.ricardobevi.contactsapp.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.ricardobevi.contactsapp.R;

/**
 * Created by ric on 01/11/15.
 */
public class ConctactDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_contact_detail, container, false);
    }
}
