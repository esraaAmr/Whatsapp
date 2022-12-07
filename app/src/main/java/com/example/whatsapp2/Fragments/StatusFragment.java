package com.example.whatsapp2.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp2.Adapters.StatusListAdapter;
import com.example.whatsapp2.Models.CallsModel;
import com.example.whatsapp2.Models.StatusModel;
import com.example.whatsapp2.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.security.Permission;
import java.util.ArrayList;
import java.util.Objects;

public class StatusFragment extends Fragment {
    View view;
    TextView textView;
    RecyclerView recyclerView;
    ImageView useImage;
    ArrayList<StatusModel> statusModels = new ArrayList<>();
    StorageReference firebaseStorage;
    Uri imageUri;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_status, container, false);
        recyclerView = view.findViewById(R.id.status_recycler);
        textView = view.findViewById(R.id.status_person_name);
        textView.setOnClickListener(view -> uploadImage());
        useImage = view.findViewById(R.id.status_photo);
        firebaseStorage = FirebaseStorage.getInstance().getReference().child("Users");
        useImage.setOnClickListener(view ->{
                    checkGalleryPermission();
                });

        RecyclerDefinition();
        return view;
    }
    private void RecyclerDefinition() {
        statusModels.clear();
        statusModels.add(new StatusModel(R.drawable.model1,"Esraa Amr","1 minute ago"));
        statusModels.add(new StatusModel(R.drawable.model2,"Eslam Amr","30 minutes ago"));
        statusModels.add(new StatusModel(R.drawable.model7,"Muhammad Abdelfattah","45 minutes ago"));
        statusModels.add(new StatusModel(R.drawable.model3,"Asmaa Mohamed","1 hour ago"));
        statusModels.add(new StatusModel(R.drawable.model4,"Sara Mohamed","2 hours ago"));
        statusModels.add(new StatusModel(R.drawable.model5,"Ayatan Mustafa","2 hours ago"));
        statusModels.add(new StatusModel(R.drawable.model6,"Aya Amr","3 hours ago"));
        StatusListAdapter adapter = new StatusListAdapter(statusModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    
    // Beshof Al permission eza kan Mofa3al or not
    private void checkGalleryPermission(){
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
            //getImage directly
            mGetImage.launch("image/*");
        } else if(ActivityCompat.shouldShowRequestPermissionRationale( // if it was asked before or not
                (Activity) requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)){
            /* if it was asked before and the user clicked denied , we will show him an educational UI to
            tell him how importance this permission
             */
            showExplainMessage("Storage Permission","Need Permission to access the Gallery");

        }else{
            ActivityCompat.requestPermissions(
                    (Activity) requireContext(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},45);
            // if it wasn't granted >> we will show the user the dialog and he will choose again
            permissionRequestLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
    }

    private final ActivityResultLauncher<String> permissionRequestLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), this::onActivityResult);
    private void showExplainMessage(String title,String message){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
        alertDialog.setMessage(message);
        alertDialog.setTitle(title);
        alertDialog.setPositiveButton("Ok", (dialogInterface, i) -> {
            dialogInterface.dismiss();
            permissionRequestLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private final ActivityResultLauncher<String> mGetImage =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null){
                    imageUri = uri;
                    useImage.setImageURI(uri);
                }
            });

    private void onActivityResult(Boolean isGranted) {
        if (isGranted) {
            // getImage
            mGetImage.launch("image/*");
        } else {
            // return to the activity
            Toast.makeText(requireContext(), "Feature not available", Toast.LENGTH_LONG).show();
        }
    }
    private void uploadImage(){
        /*
         there are two storageReference -> one for delivering and one for uploading as
         if there is one storage reference and many users uploading photo in the same time, there will be an error
         putFile -> is a method for uploading on firebase
         */
        final  StorageReference newStorageReference = firebaseStorage.child(System.currentTimeMillis()+"."+getFileExtension(imageUri));
        newStorageReference.putFile(imageUri).addOnSuccessListener(taskSnapshot ->
                newStorageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                }));
    }
    private String getFileExtension(Uri uri) {
        String extension;
        ContentResolver contentResolver = requireActivity().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        extension= mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
        return extension;
    }

    /* this type of coding is dupricated
     private void getImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
       // Hamayez ely gayally eza kan image or video by RequestCode
        startActivityForResult(intent,100);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){

        }else if(requestCode == 200){

        }else{

        }
    }
     */

}
