package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottom=findViewById(R.id.bottom_nav);
        loadFrag(new HomeFragment());

        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;
                if(item.getItemId()==R.id.nav_home){
                    fragment=new HomeFragment();
                }
                else if(item.getItemId()==R.id.nav_call){
                    fragment=new CallFragment();
                }
                else if(item.getItemId()==R.id.nav_history){
                    fragment=new HistoryFragment();
                }
                else{
                    fragment=new HomeFragment();
                }
                loadFrag(fragment);
                Toast.makeText(MainActivity.this, "Hii", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    public boolean loadFrag(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            return true;
        }
        return false;
    }
}