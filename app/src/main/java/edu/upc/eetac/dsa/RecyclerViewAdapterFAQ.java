package edu.upc.eetac.dsa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterFAQ extends RecyclerView.Adapter<RecyclerViewAdapterFAQ.ViewHolder> {

    List<FAQ> listaFAQs = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView question;
        public TextView answer;
        public View layout;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            layout = itemLayoutView;
            question = (TextView) itemLayoutView.findViewById(R.id.Question);
            answer = (TextView) itemLayoutView.findViewById(R.id.answer);
        }
    }

    public RecyclerViewAdapterFAQ(List<FAQ> listaFAQs) {
        this.listaFAQs = listaFAQs;
    }

    public void add (int position, FAQ faq){
        listaFAQs.add(position, faq);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.question.setText("Question"+listaFAQs.get(position).getQuest());
        viewHolder.answer.setText("Answer"+listaFAQs.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return listaFAQs.size();
    }
}

