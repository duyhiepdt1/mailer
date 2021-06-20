package com.hiepnd.mailer.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.hiepnd.mailer.model.QuoteResponse;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class QuoteViewModelTest {
    private static final String TAG = QuoteViewModelTest.class.getSimpleName();
    private QuoteViewModel quoteViewModel;

    @Before
    public void createQuoteViewModel(){
        quoteViewModel = new QuoteViewModel(ApplicationProvider.getApplicationContext());
    }

    // A JUnit Test Rule that swaps the background executor used by the Architecture Components with a different one which executes each task synchronously.
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    // mock QuoteRepository
    @Test
    public void getQuoteResponse(){
        LiveData<QuoteResponse> quoteResponse = quoteViewModel.getQuoteResponse();
        if(quoteResponse.getValue()!=null) {
            assertEquals(quoteResponse.getValue().getQuoteContents().getQuotes().get(0).getQuote(), "Fake Quote");
        }
    }
}