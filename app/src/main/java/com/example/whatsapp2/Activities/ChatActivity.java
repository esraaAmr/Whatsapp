package com.example.whatsapp2.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whatsapp2.Adapters.ChatListAdapter;
import com.example.whatsapp2.Adapters.ChatTextAdapter;
import com.example.whatsapp2.Models.ChatTextModel;
import com.example.whatsapp2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    EditText chatText;
    ImageView chatButton,backButton;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference; //RealTime
    RecyclerView recyclerView;
    ArrayList<ChatTextModel> chatTextModels = new ArrayList<>();
    ChatTextAdapter adapter = new ChatTextAdapter(chatTextModels);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        backButton = findViewById(R.id.imageBack);
        backButton.setOnClickListener(view -> {
            finish();

        });
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = findViewById(R.id.chatRecyclerView);
        chatText = findViewById(R.id.inputMessage);
        chatButton = findViewById(R.id.sendMessageImg);
        chatButton.setOnClickListener(view -> {
            String message = chatText.getText().toString().trim();
            if (!message.isEmpty()){
                sendMessage(message);
            }

        });
        getData();
    }
    private void sendMessage(String message){
        databaseReference.child("Messages").push().setValue(new ChatTextModel(message,firebaseAuth.getUid()));
        chatText.setText("");
    }
    private void getData(){
        databaseReference.child("Messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*
                return json of firebase
                 */
                chatTextModels.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){ // Cut The parent
                    chatTextModels.add(snapshot1.getValue( ChatTextModel.class));
                }
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}