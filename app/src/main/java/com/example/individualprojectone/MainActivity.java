package com.example.individualprojectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button login;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.welcome_screen_user_name);
        password = findViewById(R.id.welcome_screen_password);
        login = findViewById(R.id.welcome_screen_login);
        register = findViewById(R.id.welcome_screen_register);

        login.setOnClickListener(new LoginAction());

        register.setOnClickListener(new RegisterAction());



    }


    private class LoginAction implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //First we would have to validate the user input. This would normally have to be ran against an existing database of user accounts but we will assume that'
            //unless empty the account exists

            boolean isValadUSerName = true;
            if (!TextUtils.isEmpty(userName.getText().toString()) && !TextUtils.isEmpty(password.getText().toString()) && isValadUSerName) {
                Intent move = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(move);
            }

            else {
                Toast errorMessage = Toast.makeText(MainActivity.this, R.string.welcome_screen_login_error_message, Toast.LENGTH_LONG);
                errorMessage.setGravity(Gravity.CENTER, 0, 0);
                errorMessage.show();
            }


        }
    }


    private class RegisterAction implements View.OnClickListener {
        @Override
        public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(i);
        }
    }


}
