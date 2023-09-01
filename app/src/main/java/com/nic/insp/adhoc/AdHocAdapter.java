package com.nic.insp.adhoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;
import com.nic.insp.routinspections.DescAdapter;
import com.nic.insp.routinspections.ImageUploadListener;
import com.nic.insp.routinspections.RoutInspectionModel;

import java.util.List;

public class AdHocAdapter extends  RecyclerView.Adapter<AdHocAdapter.PostViewHolder>{

    private List<AdHocModel> adhocList;
    private AdHocImageUploadListener imageUploadListener;
    private Context context;

    public AdHocAdapter(Context context, AdHocImageUploadListener imageUploadListener, List<AdHocModel> routList) {
        this.adhocList = routList;
        this.imageUploadListener = imageUploadListener;
        this.context = context;
    }



    @NonNull
    @Override
    public AdHocAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adhoc_row,parent,false);

        return new PostViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdHocAdapter.PostViewHolder holder, int position) {
        AdHocModel adhocpost= adhocList.get(position);
        holder.bind(adhocpost);
        AdhocDescAdapter adhocDescAdapter= new AdhocDescAdapter(imageUploadListener,adhocpost.getAdhocdescription(),position);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        holder.adhocDescriptionRecyclerView.setLayoutManager(layoutManager);
        holder.adhocDescriptionRecyclerView.setAdapter(adhocDescAdapter);

    }


//    public int getItemCount() {
//        r
//
//    }

    @Override
    public int getItemCount() {
        return adhocList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView adhocInspIdTextView;
        private TextView adhocTalukTextView;
        private TextView adhocdeptTextView;
        private RecyclerView adhocDescriptionRecyclerView ;
        private TextView adhocLdateTextView;
        private TextView adhocStatusextView;
        private TextView adhocAssignedoff;
        private TextView adhocCreatat;
        private TextView adhocCreateby;
        private TextView adhocDistrict;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            adhocTalukTextView=itemView.findViewById(R.id.adhoctaluk);
            adhocdeptTextView=itemView.findViewById(R.id.adhocdept);
            adhocLdateTextView=itemView.findViewById(R.id.adhocldate);
            adhocDistrict=itemView.findViewById(R.id.adhocdistrict);
        }

        public void bind(AdHocModel adhocpost) {

            adhocTalukTextView.setText(adhocpost.getAdhoctaluk());
            adhocdeptTextView.setText(adhocpost.getAdhocdepartment());
            adhocLdateTextView.setText(adhocpost.getAdhoclastdate());
            adhocDistrict.setText(adhocpost.getAdhocdistrict());

        }
    }
}
