package com.example.whatsapp2.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.whatsapp2.Activities.ChatActivity;
import com.example.whatsapp2.Activities.MainActivity;
import com.example.whatsapp2.Activities.SettingActivity;
import com.example.whatsapp2.Adapters.ChatListAdapter;
import com.example.whatsapp2.Models.ChatsModel;
import com.example.whatsapp2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatsFragment extends Fragment implements ChatListAdapter.onChatClickListener{
    RecyclerView recyclerView;
    ArrayList<ChatsModel> chatsModels = new ArrayList<>();
    TextView chat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        chat = view.findViewById(R.id.chat_person_name);
//        chat.setOnClickListener(view1 -> {
//
//        });
        setUpRecycler(view);
        return view;
    }

    private void setUpRecycler(View view) {
        chatsModels.clear();
        chatsModels.add(new ChatsModel(R.drawable.model1, "Esraa Amr", "Hello How are You?", "10:00 Am"));
        chatsModels.add(new ChatsModel(R.drawable.model2, "Eslam Amr", "Bye", "11:00 Am"));
        chatsModels.add(new ChatsModel(R.drawable.model3, "Asmaa Mohamed", "Hahahaahhahha", "9:00 Am"));
        chatsModels.add(new ChatsModel(R.drawable.model4, "Sara Mohamed", "Hi Esraa", "8:30 Am"));
        chatsModels.add(new ChatsModel(R.drawable.model5, "Ayatan Mustafa", "Helloo", "11:00 Bm"));
        chatsModels.add(new ChatsModel(R.drawable.model6, "Aya Amr", "Haha", "7:30 Bm"));
        recyclerView = view.findViewById(R.id.chat_recycler);
        ChatListAdapter adapter = new ChatListAdapter(this, chatsModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onClick(int position) {

        Intent i = new Intent(getActivity(), ChatActivity.class);
        i.putExtra("name", chatsModels.get(position).getChatName());
        startActivity(i);

    }
}