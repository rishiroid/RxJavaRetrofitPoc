package net.rishiz.rxjavaretrofitpoc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.rishiz.rxjavaretrofitpoc.databinding.RowHolderBinding;

import net.rishiz.rxjavaretrofitpoc.model.EntriesDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemRowHolder> {
    ArrayList<EntriesDTO> entriesItemList;
    Context context;
    ClickInterface clickInterface;

    public ItemAdapter(List<EntriesDTO> entriesItemList, Context context, ClickInterface clickInterface) {
        this.context = context;
//        this.entriesItemList=entriesItemList;
        this.entriesItemList=new ArrayList<>();
        this.entriesItemList.addAll(entriesItemList);
        this.clickInterface = clickInterface;
    }


    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        @NonNull RowHolderBinding view = RowHolderBinding.inflate(inflater, parent, false);
//        View view= LayoutInflater.from(context).inflate(R.layout.row_holder,parent,false);
        return new ItemRowHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {
        holder.api.setText(entriesItemList.get(position).getAPI());
        holder.auth.setText(entriesItemList.get(position).getAuth());
        holder.category.setText(entriesItemList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return entriesItemList.size();
    }

    public interface ClickInterface {
        void onRowClick(int itemPosition);
    }

    class ItemRowHolder extends RecyclerView.ViewHolder {
        TextView api, auth, category;

        public ItemRowHolder(@NonNull RowHolderBinding binding) {
            super(binding.getRoot());
            api = binding.api;
            auth = binding.auth;
            category = binding.category;
            binding.card.setOnClickListener(view -> clickInterface.onRowClick(getAdapterPosition()));

        }
    }
}
