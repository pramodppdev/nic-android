package com.nic.insp.routinspections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.nic.insp.JsonHolderApi;
import com.nic.insp.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoutineInspection extends AppCompatActivity {

    private RecyclerView routRecyclerView;
    private RoutInspAdapter routInspAdapter;
    private List<RoutInspectionModel> routList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_inspection);
        routRecyclerView = findViewById(R.id.recyclerRoutIncpection);
        routRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        routList = new ArrayList<>();
        routInspAdapter = new RoutInspAdapter(routList);
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


}