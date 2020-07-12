package com.example.user.mycontacts.models;

public class ContactData {

    private int mId;
    private String mName;
    private String mPhoneNumberType;
    private String mPhoneNumber;
    private String mEmailType;
    private String mEmail;
    private int mViewType;

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    private int mImageResource;

    public ContactData(){

    }

    public ContactData(int mId,
                       String mName,
                       String mPhoneNumberType,
                       String mPhoneNumber,
                       String mEmailType,
                       String mEmail,
                       int mViewType,
                       int mImageResource) {
        this.mId = mId;
        this.mName = mName;
        this.mPhoneNumberType = mPhoneNumberType;
        this.mPhoneNumber = mPhoneNumber;
        this.mEmailType = mEmailType;
        this.mEmail = mEmail;
        this.mViewType = mViewType;
        this.mImageResource = mImageResource;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumberType() {
        return mPhoneNumberType;
    }

    public void setmPhoneNumberType(String mPhoneNumberType) {
        this.mPhoneNumberType = mPhoneNumberType;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmEmailType() {
        return mEmailType;
    }

    public void setmEmailType(String mEmailType) {
        this.mEmailType = mEmailType;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmViewType() {
        return mViewType;
    }

    public void setmViewType(int mViewType) {
        this.mViewType = mViewType;
    }
}
