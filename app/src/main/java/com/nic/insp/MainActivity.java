package com.nic.insp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nic.insp.auth.ApiClient;
import com.nic.insp.auth.ApiResponse;
import com.nic.insp.auth.AuthenticationRequest;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button loginButton;

    private JsonHolderApi jsonHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.user);
        etPassword = findViewById(R.id.pass);
        loginButton = findViewById(R.id.userbt);

        jsonHolderApi = ApiClient.getRetrofitInstance().create(JsonHolderApi.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String officerName = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                AuthenticationRequest request = new AuthenticationRequest(officerName, password);

                Call<ResponseBody> call = jsonHolderApi.authenticate(request);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String responseBodyString = response.body().string();
                                // Parse and validate the response here

                                if (responseBodyString.contains("Succees")) {
                                    // Authentication successful, navigate to HomeActivity
                                    Intent intent = new Intent(MainActivity.this, activity_home.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Authentication failed, show an error message
                                    Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Handle HTTP error
                            Toast.makeText(MainActivity.this, "HTTP error: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Handle network or other errors
                        Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("Network Error", "Network request failed", t);
                    }
                });
            }
        });
    }
}