package net.rishiz.rxjavaretrofitpoc;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import net.rishiz.rxjavaretrofitpoc.databinding.ActivityDetailsBinding;
import net.rishiz.rxjavaretrofitpoc.model.EntriesDTO;

public class DetailsActivity extends AppCompatActivity {


    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();

        binding.api.setText(intent.getStringExtra("api"));
        binding.auth.setText(intent.getStringExtra("auth"));
        binding.cors.setText(intent.getStringExtra("cors"));
        binding.link.setText(intent.getStringExtra("link"));
        binding.discription.setText(intent.getStringExtra("discription"));
        binding.category.setText(intent.getStringExtra("category"));

    }

}