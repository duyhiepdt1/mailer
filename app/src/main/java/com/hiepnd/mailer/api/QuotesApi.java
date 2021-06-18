package com.hiepnd.mailer.api;



import com.hiepnd.mailer.model.QuoteResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface QuotesApi {

    @GET("qod")
    Call<QuoteResponse> getQuotes(@Query("language") String language);
}
