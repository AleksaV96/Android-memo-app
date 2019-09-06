package com.example.aleksav.memoreminderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login(){

        TextView usernameInput = (TextView)findViewById(R.id.inputUserName);
        final String username = usernameInput.getText().toString();

        TextView passwordInput = (TextView)findViewById(R.id.inputPassword);
        final String password = passwordInput.getText().toString();

        if (password.equals("admin") && username.equals("admin")) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else {
            TextView loginErrorText = (TextView)findViewById(R.id.loginErrorText);
            loginErrorText.setText("Wrong username or password!");
        }
    }

}
