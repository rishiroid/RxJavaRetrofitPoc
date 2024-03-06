package net.rishiz.rxjavaretrofitpoc;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import net.rishiz.rxjavaretrofitpoc.adapter.ItemAdapter;
import net.rishiz.rxjavaretrofitpoc.databinding.ActivityMainBinding;
import net.rishiz.rxjavaretrofitpoc.model.EntriesDTO;
import net.rishiz.rxjavaretrofitpoc.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ClickInterface {
    private final String TAG = MainActivity.class.getName();
    List<EntriesDTO> entriesItemsList;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Log.d(TAG, "onCreate");


        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        recyclerView = binding.recyclerview;


        viewModel.apis.observe(this, it -> {
            Log.d(TAG, "apis" + it);
        });

        viewModel.getData().observe(this, response -> {
            entriesItemsList = response.getEntries();
            Log.d(TAG, "entriesItemsList" + entriesItemsList.get(1).getAPI());
            adapter = new ItemAdapter(entriesItemsList, this, this);
            recyclerView.setAdapter(adapter);
        });

    }

    @Override
    public void onRowClick(int itemPosition) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("api", entriesItemsList.get(itemPosition).getAPI());
        intent.putExtra("auth", entriesItemsList.get(itemPosition).getAuth());
        intent.putExtra("cors", entriesItemsList.get(itemPosition).getCors());
        intent.putExtra("link", entriesItemsList.get(itemPosition).getLink());
        intent.putExtra("description", entriesItemsList.get(itemPosition).getDescription());
        intent.putExtra("category", entriesItemsList.get(itemPosition).getCategory());
        startActivity(intent);

    }
}