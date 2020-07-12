package com.example.user.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.example.user.mycontacts.R;
import com.example.user.mycontacts.data.DefaultDataGenerator;
import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.presenters.EditContactsContract;
import com.example.user.mycontacts.presenters.EditContactPresenter;
import com.example.user.mycontacts.util.Common;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class EditContactActivity extends AppCompatActivity implements EditContactsContract.View {

    private int mContactId;
    private ImageButton mIbAbort;
    private ImageButton mIbConfirm;
    private TextInputEditText mEtName;
    private TextInputEditText mEtphoneNumber;
    private TextInputEditText mEtemail;
    private ImageView mIvAvatar;
    private AppCompatSpinner mSpinnerPhoneType;
    private AppCompatSpinner mSpinnerEmailType;
    private EditContactPresenter mEditContactPresenter;
    private String mPhoneType;
    private String mMailType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        mEditContactPresenter = new EditContactPresenter( this );
        initControls();
        loadContactData();
        setupSpinners();
        onConfirmClicked();
        onAbortClicked();

    }

    @Override
    public void onBackPressed() {
      navigateToDetails();
    }

    private void onConfirmClicked() {
        mIbConfirm.setOnClickListener( v -> {
            String name = Objects.requireNonNull( mEtName.getText() ).toString();
            String phone = Objects.requireNonNull( mEtphoneNumber.getText() ).toString();
            String email = Objects.requireNonNull( mEtemail.getText() ).toString();
            mEditContactPresenter.saveContact(
                    new ContactData(
                            mContactId,
                            name,
                            mSpinnerPhoneType.getSelectedItem().toString(),
                            phone,
                            mSpinnerEmailType.getSelectedItem().toString(),
                            email,
                            1,
                            mIvAvatar.getId()
                    ) );
           navigateToDetails();
        } );
    }

    private void onAbortClicked() {
        mIbAbort.setOnClickListener( v -> navigateToDetails() );
    }

    private void loadContactData() {
        Intent intent = getIntent();
        mContactId = intent.getIntExtra( Common.EXTRA_CONTACT_ID,0 );
        for (ContactData contact : DefaultDataGenerator.getInstance().loadContacts()) {
            if (contact.getmId() == mContactId) {
                mEtName.setText(contact.getmName() );
                mIvAvatar.setImageResource( contact.getmImageResource() );
                mEtphoneNumber.setText( contact.getmPhoneNumber() );
                mEtemail.setText( contact.getmEmail() );
                mPhoneType = contact.getmPhoneNumberType();
                mMailType = contact.getmEmailType();

            }
        }
    }

    private void initControls() {
        mIbAbort = findViewById( R.id.ibAbort );
        mIbConfirm = findViewById( R.id.ibConfirm);
        mEtName = findViewById( R.id.etName );
        mEtemail = findViewById( R.id.etEmail );
        mEtphoneNumber = findViewById( R.id.etPhoneNumber );
        mIvAvatar = findViewById( R.id.ivEditContactAvatar );
        mSpinnerEmailType = findViewById( R.id.spinnerEmailType );
        mSpinnerPhoneType = findViewById( R.id.spinnerPhoneType );
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> adapterPhoneTypes
                = ArrayAdapter.createFromResource( this,R.array.phone_types , android.R.layout.simple_spinner_item);
        adapterPhoneTypes.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        mSpinnerPhoneType.setAdapter( adapterPhoneTypes );

        if (mPhoneType != null) {
           int position = adapterPhoneTypes.getPosition(mPhoneType);
           mSpinnerPhoneType.setSelection( position );
        }


        ArrayAdapter<CharSequence> adapterEmailTypes
                = ArrayAdapter.createFromResource( this,R.array.email_types , android.R.layout.simple_spinner_item);
        adapterPhoneTypes.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        mSpinnerEmailType.setAdapter( adapterEmailTypes );

        if (mMailType != null) {
            int position = adapterEmailTypes.getPosition(mMailType);
            mSpinnerEmailType.setSelection( position );
        }
    }

    private void navigateToDetails() {
        Intent intent = new Intent(this,DetailsActivity.class);
        intent.putExtra( Common.EXTRA_CONTACT_ID, mContactId );
        startActivity(intent);
        finish();
    }
}

