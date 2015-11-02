package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ric on 01/11/15.
 */


public class ContactDetails implements Parcelable {
    private Integer employeeId;
    private Boolean favorite;
    private String largeImageURL;
    private String email;
    private String website;
    private Adress address;

    public ContactDetails(){

    }


    protected ContactDetails(Parcel in) {
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        employeeId = in.readInt();
        favorite = in.readByte() != 0;
        largeImageURL = in.readString();
        email = in.readString();
        website = in.readString();
        address = in.readParcelable(Adress.class.getClassLoader());

    }


    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(employeeId);
        out.writeByte((byte) (favorite ? 1 : 0));
        out.writeString(largeImageURL);
        out.writeString(email);
        out.writeString(website);
        out.writeParcelable(address, flags);

    }


    public static final Creator<ContactDetails> CREATOR = new Creator<ContactDetails>() {
        @Override
        public ContactDetails createFromParcel(Parcel in) {
            return new ContactDetails(in);
        }

        @Override
        public ContactDetails[] newArray(int size) {
            return new ContactDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
