package com.example.rajeev.wikisearchapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rajeev on 14/10/18.
 */

public class WikiResponse {

    @SerializedName("batchcomplete")
    public Boolean batchcomplete;

    @SerializedName("continue")
    public Continue _continue;

    @SerializedName("query")
    public Query query;

    public Query getQuery() {
        return query;
    }


    public class Continue {

        @SerializedName("gpsoffset")
        public Integer gpsoffset;
        @SerializedName("continue")
        public String _continue;

    }

    public class Query {

        @SerializedName("redirects")
        public List<Redirect> redirects = null;

        @SerializedName("pages")
        public List<Page> pages = null;

        public List<Page> getPages() {
            return pages;
        }

    }

    public class Redirect {

        @SerializedName("index")
        public Integer index;

        @SerializedName("from")
        public String from;

        @SerializedName("to")
        public String to;

    }



}



