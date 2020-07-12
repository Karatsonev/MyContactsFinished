package com.example.user.mycontacts.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import com.example.user.mycontacts.models.ContactData;
import com.example.user.mycontacts.views.DetailsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Common {

    public static final int REQUEST_CODE = 1;
    public static final String EXTRA_CONTACT_ID = "com.example.user.mycontacts.contactId";
    public static final String[] PHONE_PERMISSIONS = {Manifest.permission.CALL_PHONE};
    public static final int VIEW_TYPE_GROUP = 0;
    public static final int VIEW_TYPE_CONTACT = 1;
    public static List<String> alphabetAvailable = new ArrayList<>();

    /**
     * Sort contact list names by alphabet
     */
    public static ArrayList<ContactData> sortContactList(ArrayList<ContactData> contacts) {

        Collections.sort( contacts, (contact, contact2) -> contact.getmName().compareTo(contact2.getmName()  ) );

        return contacts;
    }

    /**
     * Add alphabet char to the header of contact list
     */
    public static ArrayList<ContactData> addAlphabets(ArrayList<ContactData> contacts) {

        int i;
        ArrayList<ContactData> customList = new ArrayList<>();
        ContactData firstPosition = new ContactData();
        firstPosition.setmName(String.valueOf( contacts.get( 0 ).getmName().charAt( 0 ) )  );
        firstPosition.setmViewType( VIEW_TYPE_GROUP );
        alphabetAvailable.add( String.valueOf( contacts.get( 0 ).getmName().charAt( 0 ) ) );
        customList.add(firstPosition);

        for ( i=0; i<contacts.size() - 1; i++) {

         if (!contacts.get(i).getmName().isEmpty() && !contacts.get(i).getmName().equals( "" )) {
             ContactData contact = new ContactData();
             char name1 = contacts.get(i).getmName().charAt( 0 ); // get first char in each contact name
             char name2 = contacts.get(i + 1).getmName().charAt( 0 ); // get the next one

             if (name1 == name2) {
                 contacts.get(i).setmViewType( VIEW_TYPE_CONTACT );
                 customList.add(contacts.get( i ));
             } else {
                 contacts.get(i).setmViewType( VIEW_TYPE_CONTACT );
                 customList.add(contacts.get( i ));
                 contact.setmName( String.valueOf( name2 ) );
                 contact.setmViewType( VIEW_TYPE_GROUP );
                 alphabetAvailable.add(String.valueOf( name2 ));
                 customList.add(contact);
             }
         }
      }
        contacts.get(i).setmViewType( VIEW_TYPE_CONTACT );
        customList.add(contacts.get( i ));
        return customList;
    }

    public static void verifyPermissions(String[] permissions, Activity activity,int requestCode) {
        ActivityCompat.requestPermissions(
                activity,
                permissions,
                requestCode

        );
    }

    public static boolean checkPermissions(String[] permission, Activity activity) {
        int permissionRequest = ActivityCompat.checkSelfPermission(
                activity,
                permission[0]
        );
        return permissionRequest == PackageManager.PERMISSION_GRANTED;
    }
}


