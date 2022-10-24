package com.example.logingui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button login;
    ImageButton sync;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login = findViewById(R.id.log_login);
        sync = findViewById(R.id.imageBtn_sync);
        textInputLayout = findViewById(R.id.textInputLayout_user);
        autoCompleteTextView = findViewById(R.id.log_autoUser);
        password = findViewById(R.id.log_password);

        String [] items = {"item 1","item 2","item 3","item 4"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.dropdown_item, items);
        autoCompleteTextView.setAdapter(itemAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Toast.makeText(getApplicationContext(),"selezionato "+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();

                //ricordare di chiudere la tastiera
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                password.requestFocus();



            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // loggare sul database accesso


                Toast.makeText(getApplicationContext(),"IN SVILUPPO open main ",Toast.LENGTH_SHORT).show();

                // cambiare in base alla propria app
               // Intent scIntent = new Intent(MainActivity.this, MainActivity.class);
               // startActivity(scIntent);
            }
        });


        sync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"IN SVILUPPO aggiornare user da db ",Toast.LENGTH_SHORT).show();
            }
        });



    }



}