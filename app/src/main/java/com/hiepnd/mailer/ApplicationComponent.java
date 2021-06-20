package com.hiepnd.mailer;

import com.hiepnd.mailer.repository.QuoteRepository;
import com.hiepnd.mailer.service.FakeQuoteService;
import com.hiepnd.mailer.service.QuoteService;

import javax.inject.Singleton;

import dagger.Component;

// Use FakeQuoteService class to test QuoteRepository and QuoteViewModel or QuoteService to call real API
@Singleton
@Component(modules = {QuoteService.Module.class})
public interface ApplicationComponent {

    QuoteRepository quoteRepository();
}

