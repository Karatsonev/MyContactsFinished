package com.example.user.mycontacts.presenters;

import com.example.user.mycontacts.models.ContactData;

public interface EditContactsContract {


    interface View{

    }

    interface Presenter{

        void setView(EditContactsContract.View view);
        void saveContact(ContactData contactData);

    }
}
