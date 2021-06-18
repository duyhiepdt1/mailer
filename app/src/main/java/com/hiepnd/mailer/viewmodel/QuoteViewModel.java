package com.hiepnd.mailer.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hiepnd.mailer.MailApplication;
import com.hiepnd.mailer.model.QuoteResponse;
import com.hiepnd.mailer.repository.QuoteRepository;

import javax.inject.Inject;


public class QuoteViewModel extends AndroidViewModel {
    @Inject
    QuoteRepository quoteRepository;
    private LiveData<QuoteResponse> quoteResponse;


    public QuoteViewModel(@NonNull Application application) {
        super(application);
        ((MailApplication)application).appComponent.inject(this);
        this.quoteResponse = quoteRepository.getQuotes();
    }

    public LiveData<QuoteResponse> getQuoteResponse() {
        return quoteResponse;
    }
}
