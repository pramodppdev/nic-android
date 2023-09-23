package com.nic.insp.routinspections;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nic.insp.JsonHolderApi;
import com.nic.insp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoutineInspection extends AppCompatActivity implements ImageUploadListener {
    private RecyclerView routRecyclerView;
    private RoutInspAdapter routInspAdapter;
    private List<RoutInspectionModel> routList;
    private ImageView imageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private int adapterPosition;
    private int inspAdapterPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_inspection);
        routRecyclerView = findViewById(R.id.recyclerRoutIncpection);
        routRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        routList = new ArrayList<>();
        routInspAdapter = new RoutInspAdapter(RoutineInspection.this, this, routList);
        routRecyclerView.setAdapter(routInspAdapter);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://203.192.235.108:8282/api/routinsp/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JsonHolderApi jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<List<RoutInspectionModel>> call = jsonHolderApi.getRoutPosts();
        call.enqueue(new Callback<List<RoutInspectionModel>>() {
            @Override
            public void onResponse(Call<List<RoutInspectionModel>> call, Response<List<RoutInspectionModel>> response) {
                if (!response.isSuccessful()) {
                    Log.d("RoutineInspection", "API call failed: " + response.code());
                    return;
                }
                Log.d("RoutineInspection", "API call successful");

                List<RoutInspectionModel> newRoutList = response.body();
                if (newRoutList != null) {
                    routList.clear();
                    routList.addAll(newRoutList);
                    routInspAdapter.notifyDataSetChanged();
                } else {
                    Log.e("RoutineInspection", "Response body is null");
                }
            }

            @Override
            public void onFailure(Call<List<RoutInspectionModel>> call, Throwable t) {
                Log.e("RoutineInspection", "API call failed: " + t.getMessage());
            }
        });
    }

    @Override
    public void onImageUploadRequested(int adapterPosition, int inspAdapterPosition) {
        this.adapterPosition = adapterPosition;
        this.inspAdapterPosition = inspAdapterPosition;
        Toast.makeText(RoutineInspection.this, "adapter post " + adapterPosition + " inspPost " + inspAdapterPosition, Toast.LENGTH_LONG).show();
        openGalleryForResult();
    }

    private void openGalleryForResult() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            Log.d("RoutineInspection", "Image selected: " + selectedImageUri.toString());

            if (inspAdapterPosition >= 0 && inspAdapterPosition < routList.size()) {
                RoutInspectionModel inspectionModel = routList.get(inspAdapterPosition);
                if (inspectionModel != null) {
                    List<RoutInspDetails> detailsList = inspectionModel.getRoutdescription();
                    if (detailsList != null && adapterPosition >= 0 && adapterPosition < detailsList.size()) {
                        RoutInspDetails details = detailsList.get(adapterPosition);
                        if (details != null) {
                            details.setImageUri(selectedImageUri);
                            routInspAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }
}
