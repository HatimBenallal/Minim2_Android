package edu.upc.eetac.dsa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;

import edu.upc.eetac.dsa.models.*;

public class RecyclerViewAdapterFAQ extends RecyclerView.Adapter<RecyclerViewAdapterFAQ.ViewHolder> {

    List<FAQ> faqList;

    public RecyclerViewAdapterFAQ(List<FAQ> faqList) {
        this.faqList = faqList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView question;
        public TextView answer;
        public View layout;

        public ViewHolder(View view) {
            super(view);
            layout = view;
            question = (TextView) view.findViewById(R.id.Question);
            answer = (TextView) view.findViewById(R.id.answer);
        }
    }

    public void add (int position, FAQ faq){
        faqList.add(position, faq);
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
        viewHolder.question.setText("Question:"+ faqList.get(position).getQuest());
        viewHolder.answer.setText("Answer:"+ faqList.get(position).getAnswer());
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }
}

