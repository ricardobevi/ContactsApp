package com.test.ricardobevi.contactsapp.model;

import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by ric on 01/11/15.
 */


public class Contact {

    private String name;
    private Integer employeeId;
    private String company;
    private String detailsURL;
    private ContactDetails contactDetails;
    private String smallImageURL;
    private Date birthdate;
    private Phone phone;



    public Contact(){

    }
}
