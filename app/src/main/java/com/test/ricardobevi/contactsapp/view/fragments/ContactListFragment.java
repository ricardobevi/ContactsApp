package com.test.ricardobevi.contactsapp.view.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.test.ricardobevi.contactsapp.R;
import com.test.ricardobevi.contactsapp.adapter.ContactArrayAdapter;
import com.test.ricardobevi.contactsapp.helper.NetworkingHelper;
import com.test.ricardobevi.contactsapp.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


/**
 * Created by ric on 01/11/15.
 */
public class ContactListFragment  extends Fragment {

    private static final String DEBUG_TAG = "ContactListFragment";

    private NetworkingHelper networkingHelper;
    private Context mContext;
    private ArrayList<Contact> contacts;

    ListView contactsListView;
    SwipeRefreshLayout swipeLayout;
    private OnSwipeRefreshListener onSwipeRefreshListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( savedInstanceState == null ) {
            mContext = this.getActivity();
            contacts = new ArrayList<>();
            networkingHelper = NetworkingHelper.getInstance(mContext);
            onSwipeRefreshListener = new OnSwipeRefreshListener();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        contactsListView = (ListView) view.findViewById(R.id.contact_list);

        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_contact_list_swipe_refresh);
        swipeLayout.setOnRefreshListener(onSwipeRefreshListener);
        swipeLayout.setColorSchemeResources(R.color.colorPrimary);


        contactsListView.setAdapter(
                new ContactArrayAdapter(this.getActivity(), R.layout.contact_list_row, contacts)
        );

        //contactListView.setOnItemClickListener(new OnItemClickListener());

        refreshContacts();
    }


    private void refreshContacts(){

        String url = mContext.getString(R.string.contacts_url);

        JsonArrayRequest jsArrRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(DEBUG_TAG, "JSON Response: " + response.toString());
                        contacts.clear();
                        loadContacts(response);
                        ((ContactArrayAdapter)contactsListView.getAdapter()).notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(DEBUG_TAG, "Error getting JSON", error);
                    }
                });

        networkingHelper.addToRequestQueue(jsArrRequest);
    }

    private void loadContacts(JSONArray jsonContacts){

        for(int i = 0 ; i < jsonContacts.length() ; i++){
            try {
                Contact contact = new Contact(jsonContacts.getJSONObject(i));

                contacts.add(contact);

                Log.d(DEBUG_TAG,"Got Contact! " + contact);

            } catch (JSONException e) {
                Log.e(DEBUG_TAG, "Error while creating Contact object from JSON", e);
            }
        }

    }

    private class OnSwipeRefreshListener implements SwipeRefreshLayout.OnRefreshListener{
        @Override
        public void onRefresh() {

            refreshContacts();

            if (swipeLayout != null && swipeLayout.isRefreshing())
                swipeLayout.setRefreshing(false);
        }
    }
}
