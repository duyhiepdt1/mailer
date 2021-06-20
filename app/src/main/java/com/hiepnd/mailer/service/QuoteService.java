package com.hiepnd.mailer.service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.hiepnd.mailer.api.QuotesApi;
import com.hiepnd.mailer.api.RetrofitRequest;
import com.hiepnd.mailer.model.CategoryResponse;
import com.hiepnd.mailer.model.QuoteResponse;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

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
        public AbstractQuoteService QuoteServiceProvider(QuoteService quoteService) {
            return quoteService;
        }
    }

    @Inject
    public QuoteService() {

    }

    @Override
    public void callQuotesApi() {
        QuotesApi quotesApi = RetrofitRequest.getRetrofitInstance().create(QuotesApi.class);
        quotesApi.getCategories("en", false)
                .enqueue(new Callback<CategoryResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
//                        Log.d(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            HashMap catMap = response.body().getCategoryContents().getCategories();
                            Set<String> catSet = catMap.keySet();
                            int bound = catSet.size();
                            String[] catArray = new String[bound];
                            catSet.toArray(catArray);
                            Random random = new Random();
                            String category = catArray[random.nextInt(bound)];
                            quotesApi.getQuotes("en", category)
                                    .enqueue(new Callback<QuoteResponse>() {

                                        @Override
                                        public void onResponse(@NonNull Call<QuoteResponse> call, @NonNull Response<QuoteResponse> response) {
                                            Log.d(TAG, "onResponse response:: " + response);

                                            if (response.body() != null) {

                                                Log.d(TAG, "onResponse response title:: " + response.body().getQuoteContents().getQuotes().get(0).getTitle());
                                                Log.d(TAG, "onResponse response quote:: " + response.body().getQuoteContents().getQuotes().get(0).getQuote());
                                                quote.setValue(response.body());
                                            }
                                        }

                                        @Override
                                        public void onFailure(@NonNull Call<QuoteResponse> call, @NonNull Throwable t) {
                                            quote.setValue(null);
                                        }
                                    });

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                        quote.setValue(null);
                    }
                });

    }
}
