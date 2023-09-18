package com.nic.insp.routinspections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;
import java.util.List;

public class RoutInspAdapter extends RecyclerView.Adapter<RoutInspAdapter.PostViewHolder> {
    private List<RoutInspectionModel> routList;
    private ImageUploadListener imageUploadListener;
    private Context context;
    public RoutInspAdapter(Context context,ImageUploadListener listener,List<RoutInspectionModel> routList) {
            this.routList = routList;
            this.imageUploadListener = listener;
            this.context = context;
            }
    
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.rout_inspection_row, parent, false);
            return new PostViewHolder(itemView);
            }
    
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            RoutInspectionModel routpost = routList.get(position);
            holder.bind(routpost);

        DescAdapter descAdapter = new DescAdapter(imageUploadListener,routpost.getRoutdescription(),position);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.routDescriptionRecyclerView.setLayoutManager(layoutManager);
        holder.routDescriptionRecyclerView.setAdapter(descAdapter);

    }

    @Override
    public int getItemCount() {
            return routList.size();
            }
    
    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView routInspIdTextView;
        private TextView routTalukTextView;
        private TextView routInspdeptTextView;
        private RecyclerView routDescriptionRecyclerView ;
        private TextView routLdateTextView;
        private TextView routStatusextView;
        private TextView routAssignedoff;
        private TextView routCreatat;
        private TextView routCreateby;
        private TextView routDistrict;
        // Add other TextViews for other fields
    
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            routTalukTextView = itemView.findViewById(R.id.routtaluk);
            routDescriptionRecyclerView  = itemView.findViewById(R.id.routDescriptionRecyclerView);
            routInspdeptTextView = itemView.findViewById(R.id.routdept);
            routLdateTextView = itemView.findViewById(R.id.routldate);
            routDistrict = itemView.findViewById(R.id.routdistrict);

            // Initialize other TextViews
        }
    
        public void bind(RoutInspectionModel insp) {
//
            routTalukTextView.setText(insp.getRouttaluk());
            routInspdeptTextView.setText(insp.getRoutdepartment());
            routLdateTextView.setText(insp.getRoutlastDate());
//            routStatusextView.setText(insp.getRoutstatus());
//            routAssignedoff.setText(insp.getRoutassignedOfficer());
//            routCreatat.setText(insp.getRoutcreatedAt());
//            routCreateby.setText(insp.getRoutcreatedBy());
            routDistrict.setText(insp.getRoutdistrict());

//            DescAdapter descAdapter = new DescAdapter(imageUploadListener,insp.getRoutdescription(),getAdapterPosition());
//            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
//            routDescriptionRecyclerView.setLayoutManager(layoutManager);
//            routDescriptionRecyclerView.setAdapter(descAdapter);
//
            // Bind other data fields here if needed
        }
    }
}