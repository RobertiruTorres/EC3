package com.example.recetas_app;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private String validEmail = "ejemploe@idat.com.pe";
    private String validPassword = "Peru123.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setEnabled(false); // Disable the login button initially

        // Add TextWatchers to monitor changes in the email and password fields
        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if the entered email and password match the valid credentials
                if (email.equals(validEmail) && password.equals(validPassword)) {
                    // If the credentials are correct, redirect to PlatosActivity
                    Intent intent = new Intent(LoginActivity.this, PlatosActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    // TextWatcher to monitor changes in the email and password fields
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Enable the login button only if both email and password match the valid credentials
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            loginButton.setEnabled(email.equals(validEmail) && password.equals(validPassword));
        }
    };
}
