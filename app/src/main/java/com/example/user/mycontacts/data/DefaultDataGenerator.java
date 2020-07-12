package com.example.user.mycontacts.data;

import com.example.user.mycontacts.R;
import com.example.user.mycontacts.models.ContactData;
import java.util.ArrayList;

public class DefaultDataGenerator {

    private static DefaultDataGenerator INSTANCE;
    private static ArrayList<ContactData> sContactList;

    private DefaultDataGenerator() {
         sContactList = new ArrayList<>();
         generateContacts();

    }

    public static DefaultDataGenerator getInstance() {
        if (INSTANCE == null) {
           INSTANCE = new DefaultDataGenerator();
        }
        return INSTANCE;
    }

    public ArrayList<ContactData> loadContacts() {
        return sContactList;
    }

    private void generateContacts() {

        sContactList.add( new ContactData( 1,"Dwayne","Mobile","0888111222333","Business","theRock@mail.com" ,1, R.drawable.the_rock) );
        sContactList.add( new ContactData( 2,"Arnold","Home","0787444555666","","" ,1,R.drawable.arnold) );
        sContactList.add( new ContactData( 3,"Dolph","","","Business","dolph@abv.bg" ,1,R.drawable.dolph) );
        sContactList.add( new ContactData( 4,"Batman","Business","0886312767657","Personal","batman@mai.com" ,1,R.drawable.batman) );
        sContactList.add( new ContactData( 5,"Spiderman","","","Personal","spiderman@abv.bg" ,1,R.drawable.spiderman) );
        sContactList.add( new ContactData( 6,"Clark","Home","0886124123453","","" ,1,R.drawable.clark) );
        sContactList.add( new ContactData( 7,"Mike Tyson","","","business","mike@mail.net" ,1,R.drawable.mike) );
        sContactList.add( new ContactData( 8,"Sandra","Home","0889322223227","Personal","sandra@mail.com" ,1,R.drawable.sandra) );
        sContactList.add( new ContactData( 9,"John","Business","0888111222333","Personal","john@mail.com" ,1,R.drawable.vin) );
        sContactList.add( new ContactData( 10,"Vin Diesel","Mobile","0787444555646","","" ,1,R.drawable.vin) );
        sContactList.add( new ContactData( 11,"Kitodar","","","Business","kitodar@abv.bg" ,1,R.drawable.kitodar) );
        sContactList.add( new ContactData( 12,"Nicole","Mobile","0886312767657","personal","nicole@mai.com" ,1,R.drawable.nicole) );
        sContactList.add( new ContactData( 13,"Steve","","","Business","steve@abv.bg" ,1,R.drawable.steve) );
        sContactList.add( new ContactData( 14,"Sandy","Mobile","0886124123453","","" ,1,R.drawable.sandy) );
        sContactList.add( new ContactData( 15,"Michael","","","Personal","michael@mail.net" ,1,R.drawable.michael) );
        sContactList.add( new ContactData( 16,"Jenifer","Home","0889322223227","Personal","jenifer@mail.com" ,1,R.drawable.jenifer) );
        sContactList.add( new ContactData( 17,"Gilbert","Business","0888111222666","Personal","george@mail.com" ,1,R.drawable.the_rock) );

    }
}
