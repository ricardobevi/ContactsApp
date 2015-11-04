package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ric on 01/11/15.
 */


public class Address implements Parcelable{
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Double latitude;
    private Double longitude;


    public Address(JSONObject jsonObject) throws JSONException {
        street = jsonObject.getString("street");
        city = jsonObject.getString("city");
        state = jsonObject.getString("state");
        country = jsonObject.getString("country");
        zip = jsonObject.getString("zip");
        latitude = jsonObject.getDouble("latitude");
        longitude = jsonObject.getDouble("longitude");
    }

    protected Address(Parcel in) {
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

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zip='" + zip + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
