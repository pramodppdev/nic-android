package com.nic.insp.adhoc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nic.insp.R;
import com.nic.insp.routinspections.ImageUploadListener;
import com.nic.insp.routinspections.RoutInspDetails;

import java.util.List;

public class AdhocDescAdapter extends RecyclerView.Adapter<AdhocDescAdapter.adhocDescViewHolder> {


    private List<AdHocDetails> descriptionList;
    private Button uploadImageButton;

    private AdHocImageUploadListener imageUploadListener;

    private int inspAdapterPosition;

    public AdhocDescAdapter(AdHocImageUploadListener imageUploadListener, List<AdHocDetails> adhocdescription, int position) {
        this.imageUploadListener = imageUploadListener;
        this.descriptionList = adhocdescription;
        this.inspAdapterPosition = position;
    }


    @NonNull
    @Override
    public AdhocDescAdapter.adhocDescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adhoc_description_row,parent,false);
        return new adhocDescViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdhocDescAdapter.adhocDescViewHolder holder, int position) {
//        RoutInspDetails routInspDetails = descriptionList.get(position);
//        holder.bind(routInspDetails,position);

        AdHocDetails adHocDetails= descriptionList.get(position);
        holder.bind(adHocDetails,position);



        if ("Yes".equals(adHocDetails.getAdhocimagereq())) {
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

        if (adHocDetails.getAdhocimageUri() != null) {
            holder.selectedImageView.setVisibility(View.VISIBLE);
            holder.selectedImageView.setImageURI(adHocDetails.getAdhocimageUri());
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




    public class adhocDescViewHolder extends RecyclerView.ViewHolder{
        private TextView adHocContentTextView;
        private ImageView selectedImageView;

        private TextView imgReqTextView;

        public adhocDescViewHolder(@NonNull View itemView) {
            super(itemView);
            adHocContentTextView=itemView.findViewById(R.id.adHocContent);
            selectedImageView=itemView.findViewById(R.id.adhocselectedImageView);
            imgReqTextView=itemView.findViewById(R.id.adhocimgReq);
            uploadImageButton=itemView.findViewById(R.id.adhocuploadImageButton);
        }

        public void bind(AdHocDetails adHocDetails, int position) {
            adHocContentTextView.setText(adHocDetails.getAdhoccontent()); // Set the content text
            imgReqTextView.setText(adHocDetails.getAdhocimagereq());

        }
    }
}

