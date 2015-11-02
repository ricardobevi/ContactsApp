package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by ric on 01/11/15.
 */


public class Contact implements Parcelable {

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


    protected Contact(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        name = in.readString();
        employeeId = in.readInt();
        company = in.readString();
        detailsURL = in.readString();
        contactDetails = in.readParcelable(ContactDetails.class.getClassLoader());
        smallImageURL = in.readString();
        birthdate = (Date) in.readSerializable();
        phone = in.readParcelable(Phone.class.getClassLoader());
    }



    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(employeeId);
        out.writeString(company);
        out.writeString(detailsURL);
        out.writeParcelable(contactDetails, flags);
        out.writeString(smallImageURL);
        out.writeSerializable(birthdate);
        out.writeParcelable(phone,flags);

    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

}
