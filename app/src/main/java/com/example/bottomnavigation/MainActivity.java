package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);
        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.homeId) {
                    loadFragment(new HomeFragment(),false);

                } else if (id == R.id.searchId) {
                    loadFragment(new SearchFragment(),false);

                } else if (id == R.id.settingsId) {
                    loadFragment(new SettingsFragment(),false);

                } else if (id == R.id.contactId){
                    loadFragment(new ContactFragment(),false);

                } else if (id == R.id.profileId) {
                    loadFragment(new ProfileFragment(),true);


                }

                return true;
            }
        });
        bnView.setSelectedItemId(R.id.profileId);
    }
    public void loadFragment (Fragment fragment, boolean flag ){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayoutId, fragment);
        ft.commit();

    }
}







