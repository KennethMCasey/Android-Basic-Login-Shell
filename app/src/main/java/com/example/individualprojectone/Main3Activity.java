package com.example.individualprojectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText birthday;
    EditText email;
    EditText password;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        firstName = findViewById(R.id.register_firstname);
        lastName = findViewById(R.id.register_lastname);
        birthday = findViewById(R.id.register_birthdate);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);

        submit = findViewById(R.id.register_button_submit);
        submit.setOnClickListener(new ButtonAction());

    }


    private class ButtonAction implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            ArrayList<String> fieldsWithErrors = getFieldsWithErrors();

            if (fieldsWithErrors.isEmpty()) {
                Intent in = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(in);
                Toast.makeText(Main3Activity.this, "Sucess", Toast.LENGTH_LONG).show();

            }
            else {
                Toast er = Toast.makeText(Main3Activity.this, "The Following Fields Have Errors, " + fieldsWithErrors.toString() + ".",Toast.LENGTH_LONG);
                er.setGravity(Gravity.CENTER, 0, 0);
                er.show();
            }


        }

        private ArrayList<String> getFieldsWithErrors() {

            SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yyyy");

            ArrayList<String> r = new ArrayList<String>();
            if (TextUtils.isEmpty(firstName.getText().toString()) || firstName.getText().toString().length() < 3 || firstName.getText().toString().length() > 30) r.add("First Name");
            if (TextUtils.isEmpty(lastName.getText().toString())) r.add("Last Name");
            try { if (TextUtils.isEmpty(birthday.getText().toString()) || fm.parse(birthday.getText().toString()).after(Calendar.getInstance().getTime())) r.add("Birthday");}
            catch (Exception e) {r.add("Birthday");}
            if (TextUtils.isEmpty(email.getText().toString()) || !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) r.add("email");
            if (TextUtils.isEmpty(password.getText().toString())) r.add("password");

            return r;
        }
    }


}
