package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ric on 01/11/15.
 */

public class Phone implements Parcelable {
    private String work;
    private String home;
    private String mobile;

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

}
