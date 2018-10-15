package com.example.rajeev.wikisearchapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rajeev.wikisearchapp.R;
import com.example.rajeev.wikisearchapp.activity.WebViewActivity;
import com.example.rajeev.wikisearchapp.model.Page;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rajeev on 14/10/18.
 */

public class WikiPagesAdapter extends RecyclerView.Adapter<WikiPagesAdapter.PageViewHolder>{


    private List<Page> pages;
    private int rowLayout;
    private Context context;

    public WikiPagesAdapter(List<Page> pages, int rowLayout, Context context) {
        this.pages = pages;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public PageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PageViewHolder holder, int position) {

        holder.pageTitle.setText(pages.get(position).getTitle());
        if(pages.get(position).getTerms() != null && pages.get(position).getTerms().getDescription().get(0) != null)
            holder.pageDescription.setText(pages.get(position).getTerms().getDescription().get(0));

        if(pages.get(position).getThumbnail() != null){
            Picasso.get().
                    load(pages.get(position).getThumbnail().getImageUrl()).
                    into(holder.pageImage);
        }else{
            holder.pageImage.setImageResource(R.drawable.default_image);
        }

        holder.pageLayout.setTag(position);

        holder.pageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://en.wikipedia.org/?curid=" + pages.get((int)v.getTag()).getPageId();

                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("URL", url);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    public static class PageViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout pageLayout;
        ImageView pageImage;
        TextView pageTitle;
        TextView pageDescription;


        public PageViewHolder(View v) {
            super(v);
            pageLayout = (RelativeLayout) v.findViewById(R.id.pages_layout);
            pageTitle = (TextView) v.findViewById(R.id.title);
            pageImage = v.findViewById(R.id.page_image);
            pageDescription = (TextView) v.findViewById(R.id.description);
        }
    }

}
