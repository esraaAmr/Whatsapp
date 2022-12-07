package com.example.whatsapp2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whatsapp2.Models.ChatsModel;
import com.example.whatsapp2.R;
import com.example.whatsapp2.databinding.ChatItemViewBinding;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.viewHolder> {
    ArrayList<ChatsModel> chats;
    onChatClickListener onChatClickListener;

    public ChatListAdapter(onChatClickListener onChatClickListener, ArrayList<ChatsModel> chats) {
        this.chats = chats;
        this.onChatClickListener = onChatClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChatItemViewBinding binding = ChatItemViewBinding.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_item_view,parent,false));
        return new viewHolder(binding, onChatClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChatsModel movie = chats.get(position);
        holder.binding.profilePicture.setImageResource(movie.getChatImage());
        holder.binding.chatPersonName.setText(movie.getChatName());
        holder.binding.lastMessage.setText(movie.getLastMsg());
        holder.binding.chatTime.setText(movie.getLastMsgTime());
    }

    @Override
    public int getItemCount() {
        if (chats!=null) {
            return chats.size();
        }
        return 0;
    }

    public static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        onChatClickListener onChatClickListener;
        ChatItemViewBinding binding;
        public viewHolder(@NonNull ChatItemViewBinding binding, onChatClickListener onChatClickListener) {
            super(binding.getRoot());
            this.binding=binding;
            this.onChatClickListener = onChatClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onChatClickListener.onClick(getAdapterPosition());
        }
    }

    public interface onChatClickListener{
        void onClick(int position);
    }

}
