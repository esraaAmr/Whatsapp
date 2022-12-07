package com.example.whatsapp2.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.whatsapp2.Fragments.CallsFragment;
import com.example.whatsapp2.Fragments.CameraFragment;
import com.example.whatsapp2.Fragments.ChatsFragment;
import com.example.whatsapp2.Fragments.StatusFragment;

import java.util.ArrayList;

public class viewPagerAdapter extends FragmentStateAdapter {
    private int count;
    public viewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,int count) {
        super(fragmentManager, lifecycle);
        this.count=count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CameraFragment();
            case 1:
                return new ChatsFragment();
            case 2:
                return new StatusFragment();
            case 3:
                return new CallsFragment();
        }
        return new Fragment();
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
