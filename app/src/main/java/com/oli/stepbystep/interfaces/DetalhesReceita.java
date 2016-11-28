package com.oli.stepbystep.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.oli.stepbystep.R;

import java.util.ArrayList;

import database.DataConnection;

public class DetalhesReceita extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_receita);

        String sbs = getIntent().getStringExtra("sbs");

        TextView nome=(TextView) findViewById(R.id.detalhes_receipe_nome);
        final ListView ingredientes = (ListView) findViewById(R.id.detalhes_ingredientes);
        final ListView passos = (ListView) findViewById(R.id.detalhes_passos);
        nome.setText(sbs);

        DataConnection.getInstance(DataConnection.SBS).orderByChild("name").startAt(sbs).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataConnection.getInstance(DataConnection.SBS).child(dataSnapshot.getKey()).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        ArrayAdapter<String> adapter;
                        ArrayAdapter<String> adapter2;
                        if (dataSnapshot.getKey().equals("components")) {
                            ArrayList<String> favorites = new ArrayList<String>();
                            favorites.add(dataSnapshot.getValue().toString());
                            adapter = new ArrayAdapter<String>(DetalhesReceita.this, android.R.layout.simple_list_item_1, favorites);
                            ingredientes.setAdapter(adapter);
                        } else if (dataSnapshot.getKey().equals("steps")) {
                            ArrayList<String> favorites = new ArrayList<String>();
                            favorites.add(dataSnapshot.getValue().toString());
                            adapter2 = new ArrayAdapter<String>(DetalhesReceita.this, android.R.layout.simple_list_item_1, favorites);
                            passos.setAdapter(adapter2);
                        }

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
}
