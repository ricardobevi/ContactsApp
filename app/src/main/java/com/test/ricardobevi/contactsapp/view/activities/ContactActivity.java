package com.test.ricardobevi.contactsapp.view.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.ricardobevi.contactsapp.R;
import com.test.ricardobevi.contactsapp.view.fragments.ContactListFragment;

public class ContactActivity extends AppCompatActivity {

    ContactListFragment contactListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        if ( savedInstanceState == null ) {
            contactListFragment = new ContactListFragment();
            placeFragment(contactListFragment);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void placeFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.main_container, fragment);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }
}
