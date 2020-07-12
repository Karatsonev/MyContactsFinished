package com.example.user.mycontacts.views.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.user.mycontacts.R;
import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.util.Common;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ContactItemViewHolder.ContactIemListener mContactIemListener;
    private List<ContactData> mContactsList;

    public ContactsAdapter(List<ContactData> contactsList, ContactItemViewHolder.ContactIemListener mContactIemListener) {
        this.mContactIemListener = mContactIemListener;
        mContactsList = contactsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == Common.VIEW_TYPE_GROUP){
            ViewGroup group = (ViewGroup)inflater.inflate( R.layout.group_item,parent,false );
            return new GroupViewHolder(group);

        } else if (viewType == Common.VIEW_TYPE_CONTACT) {
            ViewGroup group = (ViewGroup)inflater.inflate( R.layout.contact_item,parent,false );
            return new ContactItemViewHolder(group,mContactIemListener);
        } else {
            ViewGroup group = (ViewGroup)inflater.inflate( R.layout.group_item,parent,false );
            return new GroupViewHolder(group);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return mContactsList.get(position).getmViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GroupViewHolder) {
            GroupViewHolder groupViewHolder = (GroupViewHolder)holder;
            groupViewHolder.tvGroup.setText( mContactsList.get( position ).getmName() );

        } else if (holder instanceof ContactItemViewHolder) {
            ContactItemViewHolder contactItemViewHolder = (ContactItemViewHolder)holder;
            ContactData contactItem = mContactsList.get( position );
            contactItemViewHolder.name.setText( contactItem.getmName() );
            contactItemViewHolder.phoneNumber.setText( contactItem.getmPhoneNumber() );
            contactItemViewHolder.ivContactAvatar.setImageResource(contactItem.getmImageResource());
            contactItemViewHolder.setContactItem( contactItem );

        }
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }
}
