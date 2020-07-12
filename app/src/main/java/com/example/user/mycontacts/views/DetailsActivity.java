package com.example.user.mycontacts.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.user.mycontacts.R;
import com.example.user.mycontacts.data.DefaultDataGenerator;
import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.presenters.DetailsContract;
import com.example.user.mycontacts.presenters.DetailsPresenter;
import com.example.user.mycontacts.util.Common;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    private TextView mTvName;
    private TextView mTvPhoneNumber;
    private TextView mTvPhoneType;
    private TextView mTvEmail;
    private TextView mTvEmailType;
    private CircleImageView mIvAvatar;
    private Button  mIbCall;
    private Button mIbSendEmail;
    private Button mIbSendMessage;
    private ImageButton mIbEditContact;
    private DetailsPresenter mDetailsPresenter;
    private int mContactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );
        mDetailsPresenter = new DetailsPresenter(DetailsActivity.this,this);
        initControls();
        populateDetailsData();
        setupButtons();
        setClickListeners();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent( this,ContactsActivity.class ));
        finish();
    }

    private void initControls() {

        mTvName = findViewById( R.id.tvDetailsName);
        mIvAvatar = findViewById(R.id.ivDetailsAvatar);
        mTvPhoneNumber = findViewById(R.id.tvDetailsPhoneNumber);
        mTvPhoneType = findViewById(R.id.tvDetailsNumberType);
        mTvEmail = findViewById(R.id.tvDetailsEmail);
        mTvEmailType = findViewById(R.id.tvDetailsEmailType);
        mIbCall = findViewById(R.id.ibCallFromDetails);
        mIbSendEmail = findViewById(R.id.ibSendEmailFromDetails);
        mIbSendMessage = findViewById(R.id.ibSendMessageFromDetails);
        mIbEditContact = findViewById(R.id.ibEditContact);

    }

    private void setClickListeners() {

        ContactData contactData = getCurrentContact();
        mIbEditContact.setOnClickListener( v -> {
            mDetailsPresenter.onEditContactClicked(contactData);
            finish();
        });

        if ( mIbCall.isEnabled() ) mIbCall.setOnClickListener( v -> mDetailsPresenter.onPerformCallClicked(contactData));
        if ( mIbSendMessage.isEnabled() ) mIbSendMessage.setOnClickListener( v -> mDetailsPresenter.onSendMessageClicked(contactData));
        if ( mIbSendEmail.isEnabled() ) mIbSendEmail.setOnClickListener( v -> mDetailsPresenter.onSendEmailClicked(contactData));

    }

    private void populateDetailsData() {

        Intent intent = getIntent();
        mContactId = intent.getIntExtra( Common.EXTRA_CONTACT_ID,0 );
        for (ContactData contact : DefaultDataGenerator.getInstance().loadContacts()) {
            if (contact.getmId() == mContactId) {
                mIvAvatar.setImageResource(contact.getmImageResource());
                mTvName.setText( contact.getmName() );
                mTvPhoneNumber.setText(contact.getmPhoneNumber());
                mTvPhoneType.setText(contact.getmPhoneNumberType());
                mTvEmail.setText(contact.getmEmail());
                mTvEmailType.setText(contact.getmEmailType());
            }
        }
    }

    private ContactData getCurrentContact() {

        ContactData contactData = new ContactData();
        contactData.setmId(mContactId);
        contactData.setmName(mTvName.getText().toString());
        contactData.setmPhoneNumber(mTvPhoneNumber.getText().toString());
        contactData.setmPhoneNumberType(mTvPhoneType.getText().toString());
        contactData.setmEmail(mTvEmail.getText().toString());
        contactData.setmEmailType(mTvEmailType.getText().toString());
        contactData.setmImageResource(mIvAvatar.getId());

        return contactData;
    }

    private void setupButtons() {

        if ( mTvPhoneNumber.getText() == null || mTvPhoneNumber.getText().toString().equals( "" )) {
            mIbCall.setEnabled( false );
            mIbCall.setBackgroundColor( getResources().getColor(R.color.grey) );
            mIbSendMessage.setEnabled( false );
            mIbSendMessage.setBackgroundColor( getResources().getColor(R.color.grey) );
        }

        if ( mTvEmail.getText() == null || mTvEmail.getText().toString().equals( "" )) {
            mIbSendEmail.setEnabled( false );
            mIbSendEmail.setBackgroundColor( getResources().getColor(R.color.grey) );
        }
    }
}
