package com.example.user.mycontacts.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.example.user.mycontacts.util.Common;
import com.example.user.mycontacts.views.recyclerview.ContactsAdapter;
import com.example.user.mycontacts.R;
import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.presenters.ContactsContract;
import com.example.user.mycontacts.presenters.ContactsPresenter;
import com.example.user.mycontacts.views.recyclerview.LinearLayoutManagerWithScroller;

public class ContactsActivity extends AppCompatActivity implements ContactsContract.View {

    private ContactsPresenter mContactsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contacts );
        mContactsPresenter = new ContactsPresenter( this );
        initViews();
    }

    @Override
    public void navigateToDetails(ContactData contactData) {
        Intent intent = new Intent( this,DetailsActivity.class );
        intent.putExtra( Common.EXTRA_CONTACT_ID, contactData.getmId() );
        startActivity( intent );
        finish();
    }

    @Override
    public void performCall(ContactData contactData) {
        if((Common.checkPermissions(Common.PHONE_PERMISSIONS,this))) {
            Intent callIntent = new Intent( Intent.ACTION_CALL, Uri.fromParts( "tel", contactData.getmPhoneNumber(), null ) );
            startActivity( callIntent );
    } else
            Common.verifyPermissions( Common.PHONE_PERMISSIONS,this,Common.REQUEST_CODE );

  }

    private void setupRecyclerView() {
         RecyclerView mContactsRecyclerView = findViewById( R.id.rec_view );

         LinearLayoutManager layoutManager;
        ContactsAdapter adapter
                = new ContactsAdapter( mContactsPresenter.getContacts(),mContactsPresenter.getListeners() );

        layoutManager = new LinearLayoutManagerWithScroller( this );
        mContactsRecyclerView.setLayoutManager( layoutManager );
        mContactsRecyclerView.addItemDecoration( new DividerItemDecoration( this,layoutManager.getOrientation() ) );

        mContactsRecyclerView.setAdapter( adapter );
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            //setSupportActionBar(toolbar);
        }
    }

    private void initViews() {
        setupToolbar();
        setupRecyclerView();
    }

}
