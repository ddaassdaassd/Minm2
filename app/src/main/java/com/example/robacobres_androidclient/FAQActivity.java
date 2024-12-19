package com.example.robacobres_androidclient;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.robacobres_androidclient.adapters.FAQAdapter;
import com.example.robacobres_androidclient.models.FAQ;
import com.example.robacobres_androidclient.services.ServiceBBDD;
import com.example.robacobres_androidclient.callbacks.FAQCallback;

import java.util.ArrayList;
import java.util.List;

public class FAQActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FAQAdapter adapter;
    private List<FAQ> faqList;
    private ServiceBBDD service;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // Inicializar ServiceBBDD
        service = ServiceBBDD.getInstance(this);

        // Configurar botón de retroceso
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza la actividad y vuelve atrás
            }
        });

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewFAQs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar datos
        faqList = new ArrayList<>();
        adapter = new FAQAdapter(this, faqList);
        recyclerView.setAdapter(adapter);

        // Cargar FAQs
        fetchFAQs();
    }

    private void fetchFAQs() {
        service.getFAQs(new FAQCallback() {
            @Override
            public void onFAQCallback(List<FAQ> faqs) {
                faqList.clear();
                faqList.addAll(faqs);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onMessage(String message) {
                Toast.makeText(FAQActivity.this, "Error fetching FAQs: " + message, Toast.LENGTH_SHORT).show();
                Log.e("FAQActivity", message);
            }
        });
    }

}



