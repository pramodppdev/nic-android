package com.nic.insp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.nic.insp.JsonHolderApi;
import com.nic.insp.R;
import com.nic.insp.inspection.Inspection;
import com.nic.insp.routinspections.RoutineInspection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_home extends AppCompatActivity {

    private MaterialCardView inspection, pending_inspection;
    private TextView sessionUsernameTextView;
    private JsonHolderApi jsonHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize your Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.95.210:8282/") // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of your JsonHolderApi interface
        jsonHolderApi = retrofit.create(JsonHolderApi.class);

        sessionUsernameTextView = findViewById(R.id.sessionUsernameTextView);

        // Fetch session username and update the TextView
        fetchSessionUsername();

        inspection = findViewById(R.id.routine_inspection_card);
        inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, RoutineInspection.class);
                startActivity(intent);
            }
        });

        pending_inspection = findViewById(R.id.inspection_card);
        pending_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, Inspection.class);
                startActivity(intent);
            }
        });
    }

    private void fetchSessionUsername() {
        Call<String> call = jsonHolderApi.getSessionUsername();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String sessionUsername = response.body();
                    sessionUsernameTextView.setText(sessionUsername);
                } else {
                    Toast.makeText(activity_home.this, "Failed to fetch session username", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(activity_home.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
