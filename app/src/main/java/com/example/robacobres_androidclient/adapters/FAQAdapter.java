package com.example.robacobres_androidclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.robacobres_androidclient.R;
import com.example.robacobres_androidclient.models.FAQ;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.ViewHolder> {

    private Context context;
    private List<FAQ> faqs;

    public FAQAdapter(Context context, List<FAQ> faqs) {
        this.context = context;
        this.faqs = faqs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_faq_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FAQ faq = faqs.get(position);
        holder.date.setText(faq.getDate());
        holder.question.setText(faq.getQuestion());
        holder.answer.setText(faq.getAnswer());
        holder.sender.setText(faq.getSender());
    }

    @Override
    public int getItemCount() {
        return faqs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, question, answer, sender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.faqDate);
            question = itemView.findViewById(R.id.faqQuestion);
            answer = itemView.findViewById(R.id.faqAnswer);
            sender = itemView.findViewById(R.id.faqSender);
        }
    }
}
