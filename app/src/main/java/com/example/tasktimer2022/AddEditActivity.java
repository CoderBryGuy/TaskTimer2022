package com.example.tasktimer2022;

import android.os.Bundle;
import android.util.Log;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.tasktimer2022.databinding.ActivityAddEditBinding;

public class AddEditActivity extends AppCompatActivity {
    private static final String TAG = "AddEditActivity";

    private AppBarConfiguration appBarConfiguration;
    private ActivityAddEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);

        binding = ActivityAddEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);


    }

}