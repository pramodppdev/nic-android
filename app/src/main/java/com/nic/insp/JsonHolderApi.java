
package com.nic.insp;


import com.nic.insp.auth.ApiResponse;
import com.nic.insp.auth.AuthenticationRequest;
import com.nic.insp.inspection.InspectionModel;
import com.nic.insp.routinspections.RoutInspectionModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface JsonHolderApi {

        @GET("getAllInsp")
        Call<List<InspectionModel>> getPosts();

        @GET("getAllRoutInsp")
        Call<List<RoutInspectionModel>> getRoutPosts();

        @POST("/auth/off")
        Call<ResponseBody> authenticate(@Body AuthenticationRequest request);

        @GET("session_user")
        Call<String> getSessionUsername();



    }

