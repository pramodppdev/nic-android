package com.nic.insp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;
import com.nic.insp.inspection.Inspection;

public class activity_home extends AppCompatActivity {

    private MaterialCardView inspection, pending_incpection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inspection = findViewById(R.id.routine_inspection_card);
        inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(activity_home.this, RoutineIncpection.class);
//                startActivity(intent);
            }
        });

        pending_incpection = findViewById(R.id.inspection_card);
        pending_incpection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, Inspection.class);
                startActivity(intent);
            }
        });
    }
}