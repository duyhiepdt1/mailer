package com.hiepnd.mailer.repository;

import androidx.lifecycle.LiveData;

import com.hiepnd.mailer.model.QuoteResponse;
import com.hiepnd.mailer.service.AbstractQuoteService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuoteRepository {
    private static final String TAG = QuoteRepository.class.getSimpleName();

    AbstractQuoteService quoteService;

    @Inject
    public QuoteRepository(AbstractQuoteService quoteService){
        this.quoteService = quoteService;
    }


    public LiveData<QuoteResponse> getQuotes() {
        quoteService.callQuotesApi();
        return quoteService.getQuote();
    }
}
