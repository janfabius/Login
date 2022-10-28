package com.example.logingui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    private String ipServer_log = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setSubtitle("Gui_Scan");
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
                // usare il sistema sync già implementato



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

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            case R.id.action_serverIp:

             Toast.makeText(getApplicationContext(),"IN SVILUPPO Dialog per indirizzo ip",Toast.LENGTH_SHORT).show();


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Server IP");

                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_NUMBER );
                input.setKeyListener(DigitsKeyListener.getInstance("0123456789."));

                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ipServer_log = input.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancella", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return true;
    }


}