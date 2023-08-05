package com.nic.insp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class    MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.user);
        etPassword = findViewById(R.id.pass);
        loginButton = findViewById(R.id.userbt);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();


                if (username.equals("admin") && password.equals("password")){
                    Intent intent = new Intent(MainActivity.this, activity_home.class);
                    startActivity(intent);
                } else {
                    // Show an error message or handle incorrect credentials
                    // For simplicity, we'll just display a toast message
                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
