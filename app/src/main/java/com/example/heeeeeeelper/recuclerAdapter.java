package com.example.heeeeeeelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recuclerAdapter extends RecyclerView.Adapter<recuclerAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<sqlTest> test;

    public recuclerAdapter(LayoutInflater inflater, List<sqlTest> test) {
        this.inflater = inflater;
        this.test = test;
    }

    @NonNull
    @Override
    public recuclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recuclerAdapter.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        sqlTest test = this.test.get(position);
        holder.rezultatAnk.setText("Проблем нет: " + test.getAllgood() + "\n" + "Паранойальность: " + test.getParanoik() + "\n" + "Шизоидность: " + test.getShizik() + "\n"
        + "Истерия: " + test.getIsterik() + "\n" + "Астения: " + test.getAstenik() + "\n" + "Эмоциональная неустойчивость: " + test.getEmocloh());
        holder.dataAnk.setText(test.getDate());
    }

    @Override
    public void onBindViewHolder(@NonNull recuclerAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {return test.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView rezultatAnk;
        final TextView dataAnk;

        ViewHolder(View view){
            super(view);
            rezultatAnk = view.findViewById(R.id.rezAnk);
            dataAnk = view.findViewById(R.id.dateAnk);
        }
    }
}
