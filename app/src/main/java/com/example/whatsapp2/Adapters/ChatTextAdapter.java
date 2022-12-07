package com.example.whatsapp2.Adapters;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp2.Models.ChatTextModel;
import com.example.whatsapp2.Models.ChatsModel;
import com.example.whatsapp2.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatTextAdapter extends RecyclerView.Adapter<ChatTextAdapter.viewHolder> {
    ArrayList<ChatTextModel> chats;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public ChatTextAdapter(ArrayList<ChatTextModel> chats) {
        this.chats = chats;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_container_send_message,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChatTextModel chatTextModel = chats.get(position);
        holder.textView.setText(chatTextModel.getMessage());
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textMessage);
        }
    }
}
