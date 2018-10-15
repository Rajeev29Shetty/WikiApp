package com.example.rajeev.wikisearchapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rajeev.wikisearchapp.R;
import com.example.rajeev.wikisearchapp.adapter.WikiPagesAdapter;
import com.example.rajeev.wikisearchapp.model.Page;
import com.example.rajeev.wikisearchapp.model.WikiResponse;
import com.example.rajeev.wikisearchapp.rest.ApiClient;
import com.example.rajeev.wikisearchapp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rajeev on 14/10/18.
 */

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    TextView emptyText;
    View view;

    private static final String TAG = MainFragment.class.getSimpleName();

    private ApiInterface apiService = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wiki_recycler_layout, null);
        recyclerView = view.findViewById(R.id.recycler_view);
        emptyText = view.findViewById(R.id.empty_text);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void getWikiPages(String searchQuery){
        if( searchQuery != null ){

            Call<WikiResponse> call = apiService.getWIkiPages(searchQuery);
            call.enqueue(new Callback<WikiResponse>() {
                @Override
                public void onResponse(Call<WikiResponse> call, Response<WikiResponse> response) {
                    Log.e(TAG, response.toString());

                    if(response.body().getQuery() != null){
                        emptyText.setVisibility(View.GONE);
                        List<Page> pages = response.body().getQuery().getPages();
                        recyclerView.setAdapter(new WikiPagesAdapter(pages, R.layout.list_item_page, getContext()));
                    }

                }

                @Override
                public void onFailure(Call<WikiResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });

        }

    }
}
