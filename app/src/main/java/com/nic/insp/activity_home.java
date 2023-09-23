package com.nic.insp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Gson and Retrofit as before
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://203.192.235.108:8282/") // Replace with your base URL
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

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
        // Get the session username from SharedPreferences
        String sessionUsername = sharedPreferences.getString("sessionUsername", "");
        Log.d("Session User",sessionUsername);

        // Update the TextView with the session username
        sessionUsernameTextView.setText(sessionUsername);
    }
}
