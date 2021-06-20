package com.hiepnd.mailer.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.hiepnd.mailer.model.QuoteResponse;

public abstract class AbstractQuoteService {

    protected MutableLiveData<QuoteResponse> quote = new MutableLiveData<>();

    public LiveData<QuoteResponse> getQuote() {
        return quote;
    }

    public AbstractQuoteService() {
        QuoteResponse quoteResponse = new QuoteResponse();
        quote.setValue(quoteResponse);
    }

    public abstract void callQuotesApi();
}
