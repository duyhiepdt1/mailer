package com.hiepnd.mailer;

import android.app.Application;

import com.hiepnd.mailer.repository.QuoteRepository;
import com.hiepnd.mailer.service.FakeQuoteService;
import com.hiepnd.mailer.service.QuoteService;
import com.hiepnd.mailer.viewmodel.QuoteViewModel;

import javax.inject.Singleton;

import dagger.Component;

// Use FakeQuoteService class or QuoteService to call real API
@Singleton
@Component(modules = {QuoteService.Module.class})
public interface ApplicationComponent {
    void inject(QuoteViewModel quoteViewModel);

    QuoteRepository quoteRepository();
}

