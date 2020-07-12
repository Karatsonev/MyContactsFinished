package com.example.user.mycontacts.presenters;

import com.example.user.mycontacts.models.ContactData;

public interface DetailsContract {

    interface View{
    }

    interface Presenter{
        void setView(DetailsContract.View view);
        void onSendMessageClicked(ContactData contactData);
        void onSendEmailClicked(ContactData contactData);
        void onPerformCallClicked(ContactData contactData);
        void onEditContactClicked(ContactData contactData);
    }
}
