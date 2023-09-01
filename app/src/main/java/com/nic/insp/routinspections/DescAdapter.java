package com.nic.insp.routinspections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;

import java.util.List;


public class DescAdapter extends RecyclerView.Adapter<DescAdapter.DescViewHolder> {
    private List<RoutInspDetails> descriptionList;
    private Button uploadImageButton;

    private ImageUploadListener imageUploadListener;

    private int inspAdapterPosition;

    public DescAdapter(ImageUploadListener imageUploadListener,List<RoutInspDetails> descriptionList,int inspAdapterPosition) {
        this.descriptionList = descriptionList;
        this.imageUploadListener= imageUploadListener;
        this.inspAdapterPosition=inspAdapterPosition;
    }

    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rout_description_row, parent, false);

        return new DescViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DescViewHolder holder, int position) {
        RoutInspDetails routInspDetails = descriptionList.get(position);
        holder.bind(routInspDetails,position);


        holder.routInspContentTextView.setText(routInspDetails.getRoutInspContent());

        if ("Yes".equals(routInspDetails.getImgReq())) {
            uploadImageButton.setVisibility(View.VISIBLE);
            uploadImageButton.setOnClickListener(view -> {
                // Invoke the callback with the adapter position
                if (imageUploadListener != null) {
                    imageUploadListener.onImageUploadRequested(position,inspAdapterPosition);
                }
            });
        }  else {
            uploadImageButton.setVisibility(View.GONE);
        }

        if (routInspDetails.getImageUri() != null) {
            holder.selectedImageView.setVisibility(View.VISIBLE);
            holder.selectedImageView.setImageURI(routInspDetails.getImageUri());
            uploadImageButton.setVisibility(View.GONE);
        } else {
//            routInspDetails.setImageUri(null);
            holder.selectedImageView.setVisibility(View.GONE);
        }



    }

    @Override
    public int getItemCount() {
        if (descriptionList != null) {
            return descriptionList.size();
        } else {
            return 0;
        }
    }

    public class DescViewHolder extends RecyclerView.ViewHolder {
        private TextView routInspContentTextView;
        private ImageView selectedImageView;

        private TextView imgReqTextView;

        public DescViewHolder(@NonNull View itemView) {
            super(itemView);
            routInspContentTextView = itemView.findViewById(R.id.routInspContent);
            imgReqTextView = itemView.findViewById(R.id.imgReq);
            selectedImageView = itemView.findViewById(R.id.selectedImageView);
            uploadImageButton = itemView.findViewById(R.id.uploadImageButton);
        }

        public void bind(RoutInspDetails routInspDetails, int adapterPosition) {

        }
    }




}
