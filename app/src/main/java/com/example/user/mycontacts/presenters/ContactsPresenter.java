package com.example.user.mycontacts.presenters;

import com.example.user.mycontacts.util.Common;
import com.example.user.mycontacts.views.recyclerview.ContactItemViewHolder;
import com.example.user.mycontacts.data.DefaultDataGenerator;
import com.example.user.mycontacts.models.ContactData;
import java.util.ArrayList;

public class ContactsPresenter implements ContactsContract.Presenter {

    private ContactsContract.View mView;

    public ContactsPresenter(ContactsContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void setView(ContactsContract.View view) {
        this.mView = view;
    }

    @Override
    public ArrayList<ContactData> getContacts() {
        ArrayList<ContactData> contacts = DefaultDataGenerator.getInstance().loadContacts();
        Common.sortContactList( contacts );
        contacts = Common.addAlphabets( contacts );

        return contacts;
    }

    @Override
    public ContactItemViewHolder.ContactIemListener getListeners() {
            return new ContactItemViewHolder.ContactIemListener() {
                @Override
                public void onContactItemClicked(ContactData contactData) {
                    mView.navigateToDetails( contactData );
                }

                @Override
                public void onBtnCallClicked(ContactData contactData) {
                    mView.performCall( contactData );
                }
            };
        }
    }

