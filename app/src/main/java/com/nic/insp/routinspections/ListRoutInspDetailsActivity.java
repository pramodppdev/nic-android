package com.nic.insp.routinspections;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.nic.insp.R;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ListRoutInspDetailsActivity extends Activity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button uploadImageButton;
    private DriveResourceClient driveResourceClient;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rout_insp_details);

        uploadImageButton = findViewById(R.id.uploadImageButton);
        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        // Initialize DriveResourceClient
        driveResourceClient = Drive.getDriveResourceClient(this, GoogleSignIn.getLastSignedInAccount(this));
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            uploadImageToDrive(selectedImageUri);
        }
    }

    private void uploadImageToDrive(Uri imageUri) {
        final String imageName = "MyImage.jpg";

        driveResourceClient.createContents()
                .continueWithTask(task -> {
                    DriveContents contents = task.getResult();

                    OutputStream outputStream = contents.getOutputStream();
                    try {
                        // Open a stream to the image
                        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                        writer.write("Image data goes here"); // Replace with your image data
                        writer.close();

                        // Create metadata for the file
                        MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                                .setTitle(imageName)
                                .setMimeType("image/jpeg")
                                .setStarred(true)
                                .build();

                        // Create the file in Drive
                        return driveResourceClient.getRootFolder()
                                .continueWithTask(folderTask -> {
                                    DriveFolder rootFolder = folderTask.getResult();
                                    return driveResourceClient.createFile(rootFolder, changeSet, contents);
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .addOnSuccessListener(this, driveFile -> {
                    // File uploaded successfully
                    // Handle success
                })
                .addOnFailureListener(this, e -> {
                    // Handle failure
                });
    }
}
