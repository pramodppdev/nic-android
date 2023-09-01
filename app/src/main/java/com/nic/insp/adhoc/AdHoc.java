package com.nic.insp.adhoc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.JsonHolderApi;
import com.nic.insp.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdHoc extends AppCompatActivity implements AdHocImageUploadListener {
    private RecyclerView adhocRecyclerview;

    private AdHocAdapter adHocAdapter;

    private List<AdHocModel> adHocList;
    private ImageView imageView;
    private static final int PICK_IMAGE_REQUEST = 1;
    private int adapterPosition;

    private int adhocAdapterPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adhoc);
        adhocRecyclerview = findViewById(R.id.recyclerAdHoc);
        adhocRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adHocList = new ArrayList<>();
        adHocAdapter = new AdHocAdapter(AdHoc.this, (AdHocImageUploadListener) this,adHocList);
        adhocRecyclerview.setAdapter(adHocAdapter);




        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http:203.192.235.108:8282/api/adhoc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonHolderApi jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<List<AdHocModel>> call = jsonHolderApi.getAdHocPosts();
        call.enqueue(new Callback<List<AdHocModel>>() {
            @Override
            public void onResponse(Call<List<AdHocModel>> call, Response<List<AdHocModel>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                adHocList.addAll(response.body());
                adHocList.clear();
                adHocAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AdHocModel>> call, Throwable t) {

            }
        });

    }
        @Override
        public void onImageUploadRequested ( int adapterPosition, int adhocAdapterPosition){
            this.adapterPosition = adapterPosition;
            this.adhocAdapterPosition= adhocAdapterPosition;
            Toast.makeText(AdHoc.this, "adapter post "+String.valueOf(adapterPosition)+" adhocPost "+String.valueOf(adhocAdapterPosition), Toast.LENGTH_LONG).show();

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


            AdHocModel adHocModel = adHocList.get(adhocAdapterPosition);
            if (adHocModel != null) {
                AdHocDetails details = adHocModel.getAdhocdescription().get(adapterPosition);
                if (details != null) {
                    details.setAdhocimageUri(selectedImageUri);

                    adHocAdapter.notifyDataSetChanged();
                }
            }

        }
    }
}
