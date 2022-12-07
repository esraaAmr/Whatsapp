package com.example.whatsapp2.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.whatsapp2.Adapters.viewPagerAdapter;
import com.example.whatsapp2.Fragments.SettingFragment;
import com.example.whatsapp2.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private viewPagerAdapter adapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        viewPager2 = findViewById(R.id.view_pager_container);
        tabLayout=findViewById(R.id.tab_layout);
        adapter= new viewPagerAdapter(getSupportFragmentManager(),
                this.getLifecycle(),4);
        viewPager2.setAdapter(adapter);
        viewPager2.setCurrentItem(1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(callback);
    }
    private ViewPager2.OnPageChangeCallback callback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            tabLayout.selectTab(tabLayout.getTabAt(position));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager2.unregisterOnPageChangeCallback(callback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.new_Group:
                Toast.makeText(MainActivity.this,"NewGroup Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.new_Broadcast:
                Toast.makeText(MainActivity.this,"NewBroadcast Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.linked_devices:
                Toast.makeText(MainActivity.this,"Linked Devices Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.settings:
                Toast.makeText(MainActivity.this,"Settings Selected",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(this, SettingActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}