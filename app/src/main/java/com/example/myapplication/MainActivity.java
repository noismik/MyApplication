package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //상태바의 색상 변경
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        initMenu();
        initAppBar();


    }

    private void initAppBar() {

        //ToolBar를 Appbar로 설정
        setSupportActionBar(binding.toolbar);

        binding.toolbar.setNavigationOnClickListener(v -> {
            Log.i(TAG, "탐색 아이콘이 클릭됨");
        });

    }

    private void initMenu() {

        MenuProvider menuProvider = new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.main, menu);

            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.item_cart) {
                    Log.i(TAG, "Cart 아이콘이 클릭됨");
                    return true;
                } else if(menuItem.getItemId() == R.id.item_login) {
                    Log.i(TAG, "Login 아이콘이 클릭됨");
                    return true;
                } else if(menuItem.getItemId() == R.id.item_settings) {
                    Log.i(TAG, "Settings 아이콘이 클릭됨");
                    return true;

                }
                return false;
            }
        };

        addMenuProvider(menuProvider, this);

    }
}