package com.nic.insp.inspection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nic.insp.R;

import java.util.List;

public class InspectionAdapter extends RecyclerView.Adapter<InspectionAdapter.PostViewHolder> {
    private List<InspectionModel> itemList;

    public InspectionAdapter(List<InspectionModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.incpection_row, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        InspectionModel post = itemList.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView inspIdTextView;
        private TextView talukTextView;
        private TextView inspdeptTextView;
        private TextView descTextView;
        private TextView ldateTextView;
        private TextView statusextView;
        private TextView assignedoff;
        private TextView creatat;
        private TextView createby;
        private TextView district;
        // Add other TextViews for other fields

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
//            inspIdTextView = itemView.findViewById(R.id.inspid);
            talukTextView = itemView.findViewById(R.id.taluk);
            descTextView=itemView.findViewById(R.id.description);
            inspdeptTextView=itemView.findViewById(R.id.dept);
            ldateTextView=itemView.findViewById(R.id.ldate);
//            statusextView=itemView.findViewById(R.id.status);
//            assignedoff=itemView.findViewById(R.id.assignoff);
//            creatat=itemView.findViewById(R.id.Createat);
//            createby=itemView.findViewById(R.id.createby);
            district=itemView.findViewById(R.id.district);

            // Initialize other TextViews
        }

        public void bind(InspectionModel insp) {
//            inspIdTextView.setText(insp.getInspId());
            talukTextView.setText(insp.getTaluk());
            descTextView.setText(insp.getDescription());
            inspdeptTextView.setText(insp.getDepartment());
            ldateTextView.setText(insp.getLastDate());
//            statusextView.setText(insp.getStatus());
//            assignedoff.setText(insp.getAssignedOfficer());
//            creatat.setText(insp.getCreatedAt());
//            createby.setText(insp.getCreatedBy());
            district.setText(insp.getDistric());

            // Bind other data fields here if needed
        }
    }
}