package com.example.whatsapp2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.whatsapp2.Models.CallsModel;
import com.example.whatsapp2.R;
import com.example.whatsapp2.databinding.CallItemViewBinding;

import java.util.ArrayList;

public class CallsListAdapter extends RecyclerView.Adapter<CallsListAdapter.callsViewHolder> {
    ArrayList<CallsModel> calls;

    public CallsListAdapter(ArrayList<CallsModel> calls) {
        this.calls = calls;
    }

    @NonNull
    @Override
    public callsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CallItemViewBinding binding =CallItemViewBinding.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.call_item_view,parent,false));
        return new callsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull callsViewHolder holder, int position) {
        CallsModel callsModel = calls.get(position);
        holder.binding.cardProfileImg.setImageResource(callsModel.getCallsProf());
        holder.binding.cardPersonName.setText(callsModel.getCallsName());
        holder.binding.cardTimeLong.setText(callsModel.getCallsTime());
        holder.binding.imgIcon.setImageResource(callsModel.getCallImg());
    }

    @Override
    public int getItemCount() {
        return calls.size();
    }

    public static class callsViewHolder extends RecyclerView.ViewHolder {
        CallItemViewBinding binding;
        public callsViewHolder(@NonNull CallItemViewBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
