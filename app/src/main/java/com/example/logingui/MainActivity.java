package com.example.logingui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button login;
    ImageButton sync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Log in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        login = findViewById(R.id.log_login);
        sync = findViewById(R.id.imageBtn_sync);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // loggare sul database accesso

                // cambiare in base alla propria app
                Intent scIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(scIntent);
            }
        });










    }
}