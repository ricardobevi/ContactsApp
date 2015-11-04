package com.test.ricardobevi.contactsapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

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
    private Date birthDate;
    private Phone phone;



    public Contact(){

    }

    public Contact(JSONObject jsonObject) throws JSONException {

        name = jsonObject.getString("name");
        employeeId = jsonObject.getInt("employeeId");
        company = jsonObject.getString("company");
        detailsURL = jsonObject.getString("detailsURL");
        smallImageURL = jsonObject.getString("smallImageURL");
        phone = new Phone(jsonObject.getJSONObject("phone"));

        Long rawDate = jsonObject.getLong("birthdate");
        birthDate = new Date(rawDate * 1000);
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
        birthDate = (Date) in.readSerializable();
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
        out.writeSerializable(birthDate);
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

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", company='" + company + '\'' +
                ", detailsURL='" + detailsURL + '\'' +
                ", contactDetails=" + contactDetails +
                ", smallImageURL='" + smallImageURL + '\'' +
                ", birthDate=" + birthDate +
                ", phone=" + phone +
                '}';
    }


    public String getName() {
        return name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getCompany() {
        return company;
    }

    public String getDetailsURL() {
        return detailsURL;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Phone getPhone() {
        return phone;
    }
}
