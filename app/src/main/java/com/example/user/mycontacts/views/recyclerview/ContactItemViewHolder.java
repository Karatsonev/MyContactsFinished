package com.example.user.mycontacts.views.recyclerview;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.example.user.mycontacts.R;
import com.example.user.mycontacts.models.ContactData;

import de.hdodenhof.circleimageview.CircleImageView;


public class ContactItemViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView phoneNumber;
    ImageButton ibCall;
    CircleImageView ivContactAvatar;
    private ContactData mContactItem;


    public ContactItemViewHolder(@NonNull View itemView,  final ContactIemListener listener) {
        super( itemView );
        //init views/controls
        name = itemView.findViewById( R.id.tvDetailsName);
        phoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
        ibCall = itemView.findViewById(R.id.ibCall );
        ivContactAvatar = itemView.findViewById(R.id.ivContactAvatar);

        //set click listeners
        itemView.setOnClickListener( v -> listener.onContactItemClicked( mContactItem) );
        ibCall.setOnClickListener( v -> listener.onBtnCallClicked( mContactItem ) );
    }

    public void setContactItem(ContactData contactItem){
        this.mContactItem = contactItem;
    }

    public interface ContactIemListener{
        void onContactItemClicked(ContactData contactData);
        void onBtnCallClicked(ContactData contactData);

    }
}