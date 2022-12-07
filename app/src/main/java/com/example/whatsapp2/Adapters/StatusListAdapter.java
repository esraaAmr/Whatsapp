package com.example.whatsapp2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whatsapp2.Models.StatusModel;
import com.example.whatsapp2.R;
import com.example.whatsapp2.databinding.StatusItemViewBinding;

import java.util.ArrayList;

public class StatusListAdapter extends RecyclerView.Adapter<StatusListAdapter.StatusViewHolder> {
    ArrayList<StatusModel> statusModels;

    public StatusListAdapter(ArrayList<StatusModel> statusModels) {
        this.statusModels = statusModels;
    }
    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StatusItemViewBinding binding = StatusItemViewBinding.bind(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.status_item_view,parent,false));
        return new StatusViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
        StatusModel statusModel = statusModels.get(position);
        holder.binding.profile.setImageResource(statusModel.getStatusProf());
        holder.binding.tvNamee.setText(statusModel.getStatusName());
        holder.binding.tvTimee.setText(statusModel.getStatusTime());
    }

    @Override
    public int getItemCount() {
        return statusModels.size();
    }

    public static class StatusViewHolder extends RecyclerView.ViewHolder {
        StatusItemViewBinding binding;
        public StatusViewHolder(@NonNull StatusItemViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
