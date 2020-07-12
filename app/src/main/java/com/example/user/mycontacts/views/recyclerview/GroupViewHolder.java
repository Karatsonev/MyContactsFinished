package com.example.user.mycontacts.views.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.user.mycontacts.R;

public class GroupViewHolder extends RecyclerView.ViewHolder {

    TextView tvGroup;

    public GroupViewHolder(@NonNull View itemView) {
        super( itemView );
        tvGroup = itemView.findViewById( R.id.tvGroupTitle );
    }
}
