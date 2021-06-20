package com.hiepnd.mailer.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hiepnd.mailer.ApplicationComponent;
import com.hiepnd.mailer.MailApplication;
import com.hiepnd.mailer.model.QuoteResponse;

public class QuoteViewModel extends AndroidViewModel {

    private LiveData<QuoteResponse> quoteResponse;

    public QuoteViewModel(@NonNull Application application) {
        super(application);

        ApplicationComponent applicationComponent = ((MailApplication) application).applicationComponent;
        this.quoteResponse = applicationComponent.quoteRepository().getQuotes();
    }

    public LiveData<QuoteResponse> getQuoteResponse() {
        return quoteResponse;
    }
}
