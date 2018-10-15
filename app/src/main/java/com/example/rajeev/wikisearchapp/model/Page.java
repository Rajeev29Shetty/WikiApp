package com.example.rajeev.wikisearchapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rajeev on 14/10/18.
 */

public class Page {

    @SerializedName("pageid")
    public Integer pageid;

    @SerializedName("ns")
    public Integer ns;

    @SerializedName("title")
    public String title;

    @SerializedName("index")
    public Integer index;

    @SerializedName("thumbnail")
    public Thumbnail thumbnail;

    @SerializedName("terms")
    public Terms terms;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageId() {
        return pageid;
    }

    public void setPageId(int pageid) {
        this.pageid = pageid;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public class Terms {

        @SerializedName("description")
        public List<String> description = null;

        public List<String> getDescription() {
            return description;
        }

    }

    public class Thumbnail {

        @SerializedName("source")
        public String source;
        @SerializedName("width")
        public Integer width;
        @SerializedName("height")
        public Integer height;

        public String getImageUrl() {
            return source;
        }

    }


}
