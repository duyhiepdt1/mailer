package com.hiepnd.mailer.service;



import com.hiepnd.mailer.model.QuoteContents;
import com.hiepnd.mailer.model.Quote;
import com.hiepnd.mailer.model.QuoteResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;

@Singleton
public class FakeQuoteService extends AbstractQuoteService{
    @Singleton
    @dagger.Module
    public static class Module {
        @Singleton
        @Provides
        public AbstractQuoteService QuoteServiceProvider(FakeQuoteService quoteService){
            return quoteService;
        }
    }

    @Inject
    public FakeQuoteService(){

    }

    @Override
    public void callQuotesApi() {
        Quote fakeQuote = new Quote("Fake Title", "Fake Quote", "Fake Author");
        List<Quote> fakeQuotes = new ArrayList<>();
        fakeQuotes.add(fakeQuote);
        QuoteContents fakeQuoteContents = new QuoteContents(fakeQuotes);
        QuoteResponse fakeResponse = new QuoteResponse(fakeQuoteContents);
        quote.setValue(fakeResponse);
    }
}
