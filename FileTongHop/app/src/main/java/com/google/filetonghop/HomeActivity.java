package com.google.filetonghop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_favourite:
                        Toast.makeText(HomeActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeActivity.this, ListViewActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(HomeActivity.this, ProfileActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
}