
package com.nic.insp;


import com.nic.insp.inspection.InspectionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonHolderApi {

        @GET("getAllInsp")
        Call<List<InspectionModel>> getPosts();


    }

