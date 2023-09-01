
package com.nic.insp;


import com.nic.insp.adhoc.AdHocModel;
import com.nic.insp.inspection.InspectionModel;
import com.nic.insp.routinspections.RoutInspectionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonHolderApi {

        @GET("getAllInsp")
        Call<List<InspectionModel>> getPosts();

        @GET("getAllRoutInsp")
        Call<List<RoutInspectionModel>> getRoutPosts();
        @GET("getAllAdhoc")
        Call<List<AdHocModel>> getAdHocPosts();


    }

