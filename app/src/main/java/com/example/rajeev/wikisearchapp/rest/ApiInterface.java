package com.example.rajeev.wikisearchapp.rest;

import com.example.rajeev.wikisearchapp.model.WikiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rajeev on 14/10/18.
 */

public interface ApiInterface {

    @GET("w/api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=100&pilimit=20&wbptterms=description&gpslimit=10")
    Call<WikiResponse> getWIkiPages(@Query("gpssearch") String queryText);
}
