package com.hiepnd.mailer.service;

import android.util.Log;

import com.hiepnd.mailer.api.QuotesApi;
import com.hiepnd.mailer.api.RetrofitRequest;
import com.hiepnd.mailer.model.QuoteResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class QuoteService extends AbstractQuoteService {
    private static final String TAG = QuoteService.class.getSimpleName();

    @Singleton
    @dagger.Module
    public static class Module {
        @Singleton
        @Provides
        public AbstractQuoteService QuoteServiceProvider(QuoteService quoteService){
            return quoteService;
        }
    }

    @Inject
    public QuoteService(){

    }

    @Override
    public void callQuotesApi() {
        QuotesApi quotesApi = RetrofitRequest.getRetrofitInstance().create(QuotesApi.class);
        quotesApi.getQuotes("en")
                .enqueue(new Callback<QuoteResponse>(){

                    @Override
                    public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if(response.body() != null) {

                            Log.d(TAG, "onResponse response title:: " + response.body().getContents().getQuotes().get(0).getTitle());
                            Log.d(TAG, "onResponse response quote:: " + response.body().getContents().getQuotes().get(0).getQuote());
                            quote.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<QuoteResponse> call, Throwable t) {
                        quote.setValue(null);
                    }
                });

    }
}
