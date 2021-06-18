package com.hiepnd.mailer;

import com.hiepnd.mailer.service.FakeQuoteService;
import com.hiepnd.mailer.service.QuoteService;
import com.hiepnd.mailer.viewmodel.QuoteViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {QuoteService.Module.class})
public interface AppComponent {
    void inject(QuoteViewModel quoteViewModel);
}
