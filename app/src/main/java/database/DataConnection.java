package database;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import objects.ComponentItem;

public class DataConnection {

    public static final byte COMPONENT_ITEM = 0;
    public static final byte COMPONENT_SBS = 1;
    public static final byte FAVORITE_LIST = 2;
    public static final byte SBS = 3;
    public static final byte SHOPPING_LIST = 4;
    public static final byte TYPE_SBS = 5;
    public static final byte USER = 6;

    private static DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference componentItem = mRootRef.child("componentitem");
    private static DatabaseReference componentSbs = mRootRef.child("componentsbs");
    private static DatabaseReference favoriteList = mRootRef.child("favoriteList");
    private static DatabaseReference sbs = mRootRef.child("sbs");
    private static DatabaseReference shoppingList = mRootRef.child("shoppinglist");
    private static DatabaseReference typeSbs = mRootRef.child("typesbs");
    private static DatabaseReference user = mRootRef.child("user");

    private static String key;
    private static HashMap<String, Object> result;
    private static ArrayList<String> keys;

    public static void temp2() {
        Log.e("CHILDADDED", key);
    }

    public static ArrayList<String> retrieve() {
        return keys;
    }

    public static void query(byte root, String field, String parameter) {
        DatabaseReference databaseReference = getInstance(root).child(parameter);
        Query query = databaseReference;

        result = new HashMap<>();

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                keys.add(dataSnapshot.getKey());
                Log.e("CHILD", dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static void temp() {
        Query query = componentItem.orderByChild("name").equalTo("celery");


        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ComponentItem component = dataSnapshot.getValue(ComponentItem.class);
                key = dataSnapshot.getKey();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static DatabaseReference getInstance(byte root) {
        DatabaseReference instance = mRootRef;

        switch (root) {
            case DataConnection.COMPONENT_ITEM :
                instance = componentItem;
                break;
            case DataConnection.COMPONENT_SBS :
                instance = componentSbs;
                break;
            case DataConnection.FAVORITE_LIST :
                instance = favoriteList;
                break;
            case DataConnection.SBS:
                instance = sbs;
                break;
            case DataConnection.SHOPPING_LIST :
                instance = shoppingList;
                break;
            case DataConnection.TYPE_SBS :
                instance = typeSbs;
                break;
            case DataConnection.USER :
                instance = user;
                break;
        }





/*        componentItem.orderByChild("name")
                .startAt("celery")
                .endAt("celery")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.e("TESTE", dataSnapshot.getValue(ComponentItem.class).toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/

        return instance;
    }

    public static void updateChild(byte root, Map<String, Object> childValues) {
        DatabaseReference databaseReference = getInstance(root);

        if (root == DataConnection.USER || root == DataConnection.COMPONENT_SBS || root == DataConnection.FAVORITE_LIST || root == DataConnection.SHOPPING_LIST) {
            databaseReference.updateChildren(childValues);
        } else {
            Map<String, Object> childUpdates = new HashMap<>();
            String key = databaseReference.push().getKey();
            childUpdates.put(key, childValues);
            databaseReference.updateChildren(childUpdates);
        }
    }

}
