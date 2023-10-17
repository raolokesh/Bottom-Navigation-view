package com.lokesh.bottomnavigationview;

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


        loadFrag(new Second_Fragment(),0);

        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });
//        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                int id = item.getItemId();

                if (id == R.id.nav_home){
                        loadFrag(new First_Fragment(),1);

                } else if (id == R.id.nav_status) {
                    loadFrag(new Second_Fragment(),1);

                }else if (id == R.id.nav_search){
                    loadFrag(new Third_Fragment(),1);

                } else if (id == R.id.nav_contact) {
                    loadFrag(new Four_Fragment(),1);

                }else {
                    loadFrag(new Five_Fragment(),1);

                }
                return true;
            }
        });

    }

    public void loadFrag(Fragment fragment,int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == 0){
            ft.add(R.id.container,fragment);
        }
        else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}