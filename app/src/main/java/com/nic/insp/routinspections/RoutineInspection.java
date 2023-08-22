package com.nic.insp.routinspections;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import com.nic.insp.JsonHolderApi;
import com.nic.insp.MainActivity;
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
        routInspAdapter = new RoutInspAdapter(RoutineInspection.this,this,routList);
        routRecyclerView.setAdapter(routInspAdapter);




        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http:203.192.235.108:8282/api/routinsp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonHolderApi jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<List<RoutInspectionModel>> call = jsonHolderApi.getRoutPosts();
        call.enqueue(new Callback<List<RoutInspectionModel>>() {
            @Override
            public void onResponse(Call<List<RoutInspectionModel>> call, Response<List<RoutInspectionModel>> response) {
                if(!response.isSuccessful()){

                    return;

                }
                routList.clear(); // Clear existing data
                routList.addAll(response.body()); // Add new data
                routInspAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<RoutInspectionModel> >call, Throwable t) {

                return;
            }
        });
    }


    @Override
    public void onImageUploadRequested(int adapterPosition, int inspAdapterPosition) {

        this.adapterPosition = adapterPosition;
        this.inspAdapterPosition= adapterPosition;
        Toast.makeText(RoutineInspection.this, "adapter post "+String.valueOf(adapterPosition)+" inspPost "+String.valueOf(inspAdapterPosition), Toast.LENGTH_LONG).show();

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

//            if (routList != null && adapterPosition >= 0 && adapterPosition < routList.size()) {
                RoutInspectionModel inspectionModel = routList.get(inspAdapterPosition);
                if (inspectionModel != null) {
                    RoutInspDetails details = inspectionModel.getRoutdescription().get(adapterPosition);
                    if (details != null) {
                        details.setImageUri(selectedImageUri);
//                        routInspAdapter.notifyItemChanged(adapterPosition);
                        routInspAdapter.notifyDataSetChanged();
                    }
                }
//            }
        }
    }

}