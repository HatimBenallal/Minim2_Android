package edu.upc.eetac.dsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FAQActivity extends AppCompatActivity{
    ApiInterface apiInterface;
    private List<FAQ> faqs = new ArrayList<>();
    private ProgressBar progressBar;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        apiInterface = Api.getClient();
        getFAQ();
    }

    public void getFAQ() {
        Call<List<FAQ>> call = apiInterface.getFAQ();
        call.enqueue(new Callback<List<FAQ>>() {
            @Override
            public void onResponse(Call<List<FAQ>> call, Response<List<FAQ>> response) {
                if (!response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
                if (response.isSuccessful()) {
                    faqs = response.body();
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    myAdapter = new RecyclerViewAdapterFAQ(faqs);
                    recyclerView.setAdapter(myAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<FAQ>> call, Throwable throwable) {
                call.cancel();
                Toast.makeText(getApplicationContext(), "USER NOT FOUND", Toast.LENGTH_LONG).show();
            }
        });
    }
}
