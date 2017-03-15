package com.gabo.weightless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText userInput, passwordInput;

    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userInput = (EditText) findViewById(R.id.userInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

        dbHelper = new DBHelper(this);

        Button logInButton = (Button) findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn(v);

            }
        });

        Button signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(v);
            }
        });
    }

    public void logIn(View v){
        if(userInput.getText().toString().length() > 0){
            if(dbHelper.userExists(userInput.getText().toString())){
                if(dbHelper.userValidation(userInput.getText().toString(), passwordInput.getText().toString())){
                    Toast.makeText(this, "Log IN", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, EquipmentList.class);
                    i.putExtra("user", userInput.getText().toString());
                    startActivity(i);
                }else{
                    Toast.makeText(this, "The password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "This user doesn't exist", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "You have to fill the input boxes to log in", Toast.LENGTH_SHORT).show();
        }
    }

    public void signIn(View v){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }
}
