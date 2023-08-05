package com.nic.insp.inspection;

import android.os.Bundle;

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

public class Inspection extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private InspectionAdapter postAdapter;
    private List<InspectionModel> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incpection);

        recyclerView = findViewById(R.id.recyclerIncpection);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();
        postAdapter = new InspectionAdapter(itemList);
        recyclerView.setAdapter(postAdapter);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http:203.192.235.108:8282/api/inspection/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonHolderApi jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<List<InspectionModel>> call = jsonHolderApi.getPosts();
        call.enqueue(new Callback<List<InspectionModel>>() {
            @Override
            public void onResponse(Call<List<InspectionModel>> call, Response<List<InspectionModel>> response) {
                if(!response.isSuccessful()){

                    return;

                }
                itemList.clear(); // Clear existing data
                itemList.addAll(response.body()); // Add new data
                postAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<InspectionModel>> call, Throwable t) {

                return;
            }
        });
    }


}
