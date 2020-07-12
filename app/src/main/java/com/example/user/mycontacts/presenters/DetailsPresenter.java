package com.example.user.mycontacts.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.util.Common;
import com.example.user.mycontacts.views.EditContactActivity;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View mView;
    private Context mContext;

    public DetailsPresenter(Context mContext, DetailsContract.View mView) {
        this.mView = mView;
        this.mContext = mContext;
    }


    @Override
    public void setView(DetailsContract.View view) {
        this.mView = view;
    }


    @Override
    public void onSendMessageClicked(ContactData contactData) {
        mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", contactData.getmPhoneNumber(), null)));
    }

    @Override
    public void onSendEmailClicked(ContactData contactData) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ contactData.getmEmail()});
        intent.setType("message/rfc822");
        mContext.startActivity(Intent.createChooser(intent,"Choose an Email client")); //
    }

    @Override
    public void onPerformCallClicked(ContactData contactData) {
        if((Common.checkPermissions(Common.PHONE_PERMISSIONS,(Activity)mContext))) {
            Intent callIntent = new Intent( Intent.ACTION_CALL, Uri.fromParts( "tel", contactData.getmPhoneNumber(), null ) );
            mContext.startActivity( callIntent );
        } else
            Common.verifyPermissions( Common.PHONE_PERMISSIONS,(Activity)mContext,Common.REQUEST_CODE );
    }

    @Override
    public void onEditContactClicked(ContactData contactData) {
        Intent intent = new Intent(mContext, EditContactActivity.class);
        intent.putExtra(Common.EXTRA_CONTACT_ID, contactData.getmId());
        mContext.startActivity(intent);
    }
}
