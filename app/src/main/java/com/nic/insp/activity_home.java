package com.nic.insp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;
import com.nic.insp.adhoc.AdHoc;
import com.nic.insp.inspection.Inspection;
import com.nic.insp.routinspections.RoutineInspection;

public class activity_home extends AppCompatActivity {

    private MaterialCardView inspection, pending_incpection,adhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inspection = findViewById(R.id.routine_inspection_card);
        inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, RoutineInspection.class);
                startActivity(intent);
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


        adhoc=findViewById(R.id.adhoc_inspection_card);
        adhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_home.this, AdHoc.class);
                startActivity(intent);
            }
        });
    }
}