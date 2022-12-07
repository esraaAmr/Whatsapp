package com.example.whatsapp2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp2.Adapters.CallsListAdapter;
import com.example.whatsapp2.Models.CallsModel;
import com.example.whatsapp2.R;

import java.util.ArrayList;

public class CallsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<CallsModel> callsModels = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calls, container, false);
        recyclerView = view.findViewById(R.id.calls_recycler_view);
        RecyclerDefinition();
        return view;
    }
    private void RecyclerDefinition() {
        callsModels.clear();
        callsModels.add(new CallsModel(R.drawable.model1,"Esraa Amr","2:00 PM",R.drawable.ic_call));
        callsModels.add(new CallsModel(R.drawable.model2,"Eslam Amr","Yesterday,8:00 PM",R.drawable.ic_viduo));
        callsModels.add(new CallsModel(R.drawable.model7,"Muhammad Abdelfattah","Yesterday,10:15 AM",R.drawable.ic_call));
        CallsListAdapter adapter = new CallsListAdapter(callsModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.calls_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


}