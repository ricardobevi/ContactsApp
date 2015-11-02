package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ric on 01/11/15.
 */


public class Adress implements Parcelable{
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Double latitude;
    private Double longitude;


    protected Adress(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        street = in.readString();
        city = in.readString();
        state = in.readString();
        country = in.readString();
        zip = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(street);
        out.writeString(city);
        out.writeString(state);
        out.writeString(country);
        out.writeString(zip);
        out.writeDouble(latitude);
        out.writeDouble(longitude);
    }

    public static final Creator<Adress> CREATOR = new Creator<Adress>() {
        @Override
        public Adress createFromParcel(Parcel in) {
            return new Adress(in);
        }

        @Override
        public Adress[] newArray(int size) {
            return new Adress[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
