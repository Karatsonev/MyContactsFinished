package com.example.user.mycontacts.presenters;

import com.example.user.mycontacts.data.DefaultDataGenerator;
import com.example.user.mycontacts.models.ContactData;

public class EditContactPresenter implements EditContactsContract.Presenter {

    private EditContactsContract.View mView;


    public EditContactPresenter(EditContactsContract.View mView) {
        this.mView = mView;

    }

    @Override
    public void setView(EditContactsContract.View view) {
        this.mView = view;
    }


    @Override
    public void saveContact(ContactData contactData) {
        for (ContactData contact : DefaultDataGenerator.getInstance().loadContacts())  {
            if (contact.getmId() == contactData.getmId()) {
                contact.setmName( contactData.getmName() );
                contact.setmViewType(contactData.getmViewType()  );
                contact.setmEmail( contactData.getmEmail() );
                contact.setmEmailType( contactData.getmEmailType() );
                contact.setmPhoneNumber( contactData.getmPhoneNumber() );
                contact.setmPhoneNumberType( contactData.getmPhoneNumberType() );
            }
        }
    }

}
