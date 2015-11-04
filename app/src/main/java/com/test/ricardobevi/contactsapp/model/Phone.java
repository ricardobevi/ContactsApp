package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ric on 01/11/15.
 */

public class Phone implements Parcelable {
    private String work;
    private String home;
    private String mobile;

    public Phone(JSONObject jsonObject) throws JSONException {
        work = jsonObject.getString("work");
        home = jsonObject.getString("home");
        mobile = jsonObject.getString("mobile");
    }

    protected Phone(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        work = in.readString();
        home = in.readString();
        mobile = in.readString();
    }


    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(work);
        out.writeString(home);
        out.writeString(mobile);
    }


    public static final Creator<Phone> CREATOR = new Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "work='" + work + '\'' +
                ", home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }


    public String getWork() {
        return work;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }
}
