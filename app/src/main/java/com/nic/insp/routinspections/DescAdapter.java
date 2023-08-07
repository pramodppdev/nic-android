package com.nic.insp.routinspections;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;

import java.util.List;

public class DescAdapter extends RecyclerView.Adapter<DescAdapter.DescViewHolder> {
    private List<RoutInspDetails> descriptionList;

    public DescAdapter(List<RoutInspDetails> descriptionList) {
        this.descriptionList = descriptionList;
    }

    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.rout_description_row, parent, false);
                .inflate(R.layout.rout_description_row, parent, false);

        return new DescViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DescViewHolder holder, int position) {
        RoutInspDetails routInspDetails = descriptionList.get(position);
        holder.bind(routInspDetails);
    }

    @Override
    public int getItemCount() {
        if (descriptionList != null) {
            return descriptionList.size();
        } else {
            return 0; // or return a default value
        }
    }

    public class DescViewHolder extends RecyclerView.ViewHolder {
        private TextView routInspContentTextView;
        private TextView routInspAnsTextView;
        private TextView imgReqTextView;

        private Button uploadImageButton;


        public DescViewHolder(@NonNull View itemView) {
            super(itemView);
            routInspContentTextView = itemView.findViewById(R.id.routInspContent);
            routInspAnsTextView = itemView.findViewById(R.id.routInspAns);
            imgReqTextView = itemView.findViewById(R.id.imgReq);
            uploadImageButton = itemView.findViewById(R.id.uploadImageButton);

        }

        public void bind(RoutInspDetails routInspDetails) {
            routInspContentTextView.setText(routInspDetails.getRoutInspContent());
            routInspAnsTextView.setText(routInspDetails.getRoutInspAns());
//            imgReqTextView.setText(routInspDetails.getImgReq());

            if ("Yes".equals(routInspDetails.getImgReq())) {
                uploadImageButton.setVisibility(View.VISIBLE);
                uploadImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });

            } else {
                uploadImageButton.setVisibility(View.GONE);
            }
        }
    }



}

