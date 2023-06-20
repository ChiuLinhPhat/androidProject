package com.example.question2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    EditText editTextName, editTextPhone, editTextAddress;
    Button buttonAdd;
    database database = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editTextName = (EditText) findViewById(R.id.name_edittext);
        editTextPhone =(EditText) findViewById(R.id.phone_edittext);
        editTextAddress = (EditText) findViewById(R.id.address_edittext);
        buttonAdd = (Button) findViewById(R.id.add_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Friend friendContruct = new Friend(cursor.getString(1));
                friendContruct.setName(editTextName.getText().toString());
                friendContruct.setPhoneNumber(String.valueOf(Integer.parseInt(editTextPhone.getText().toString())));
                friendContruct.setAddress(editTextAddress.getText().toString());
                if (database.insertFriend(friendContruct)>0) {
                    Toast.makeText(getApplicationContext(), "Save successfully!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Save error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}