package com.hiepnd.mailer.service;



import com.hiepnd.mailer.model.Contents;
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
        QuoteResponse fakeResponse = new QuoteResponse();
        Quote fakeQuote = new Quote();
        fakeQuote.setTitle("Fake Title");
        fakeQuote.setQuote("Fake Quote");
        fakeQuote.setAuthor("Fake Author");
        List<Quote> fakeQuotes = new ArrayList<Quote>();
        fakeQuotes.add(fakeQuote);
        Contents fakeContents = new Contents();
        fakeContents.setQuotes(fakeQuotes);
        fakeResponse.setContents(fakeContents);
        quote.postValue(fakeResponse);
    }
}
