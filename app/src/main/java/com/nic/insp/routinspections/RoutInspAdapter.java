package com.nic.insp.routinspections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;
import java.util.List;

public class RoutInspAdapter extends RecyclerView.Adapter<RoutInspAdapter.PostViewHolder> {
    private List<RoutInspectionModel> routList;
    
    public RoutInspAdapter(List<RoutInspectionModel> routList) {
            this.routList = routList;
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
            }

    @Override
    public int getItemCount() {
            return routList.size();
            }
    
    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView routInspIdTextView;
        private TextView routTalukTextView;
        private TextView routInspdeptTextView;
        private TextView routDescTextView;
        private TextView routLdateTextView;
        private TextView routStatusextView;
        private TextView routAssignedoff;
        private TextView routCreatat;
        private TextView routCreateby;
        private TextView routDistrict;
        // Add other TextViews for other fields
    
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
//            routInspIdTextView = itemView.findViewById(R.id.routinspid);
            routTalukTextView = itemView.findViewById(R.id.routtaluk);
//            routDescTextView = itemView.findViewById(R.id.routdescription);
            routInspdeptTextView = itemView.findViewById(R.id.routdept);
            routLdateTextView = itemView.findViewById(R.id.routldate);
//            routStatusextView = itemView.findViewById(R.id.routstatus);
//            routAssignedoff = itemView.findViewById(R.id.routassignoff);
//            routCreatat = itemView.findViewById(R.id.routCreateat);
//            routCreateby = itemView.findViewById(R.id.routcreateby);
            routDistrict = itemView.findViewById(R.id.routdistrict);

            // Initialize other TextViews
        }
    
        public void bind(RoutInspectionModel insp) {
//            routInspIdTextView.setText(insp.getRoutinspId());
            routTalukTextView.setText(insp.getRouttaluk());
//            routDescTextView.setText(insp.getRoutdescription());
            routInspdeptTextView.setText(insp.getRoutdepartment());
            routLdateTextView.setText(insp.getRoutlastDate());
//            routStatusextView.setText(insp.getRoutstatus());
//            routAssignedoff.setText(insp.getRoutassignedOfficer());
//            routCreatat.setText(insp.getRoutcreatedAt());
//            routCreateby.setText(insp.getRoutcreatedBy());
            routDistrict.setText(insp.getRoutdistrict());
    
            // Bind other data fields here if needed
        }
    }
}