package com.test.ricardobevi.contactsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.test.ricardobevi.contactsapp.R;
import com.test.ricardobevi.contactsapp.helper.NetworkingHelper;
import com.test.ricardobevi.contactsapp.model.Contact;

import java.util.List;

/**
 * Created by ric on 02/11/15.
 */
public class ContactArrayAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private List<Contact> contacts;

    static class ViewHolder {
        NetworkImageView contactImage;
        TextView contactName;
        TextView contactPhoneNumber;
    }


    public ContactArrayAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);

        this.context = context;
        this.contacts = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if( convertView == null ) {

            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.contact_list_row, parent, false);

            holder.contactImage = (NetworkImageView) convertView.findViewById(R.id.contact_image);
            holder.contactName  = (TextView) convertView.findViewById(R.id.contact_name);
            holder.contactPhoneNumber = (TextView) convertView.findViewById(R.id.contact_phone_number);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();

        }


        if ( contacts.size() > position ) {
            Contact contact = contacts.get(position);

            populateView(contact, holder);

        }


        return convertView;
    }

    private void populateView(Contact contact, ViewHolder holder) {
        ImageLoader imageLoader = NetworkingHelper.getInstance(context).getImageLoader();

        holder.contactName.setText(contact.getName());
        holder.contactImage.setImageUrl(contact.getSmallImageURL(),imageLoader);
        holder.contactPhoneNumber.setText(contact.getPhone().getMobile());

    }
}
