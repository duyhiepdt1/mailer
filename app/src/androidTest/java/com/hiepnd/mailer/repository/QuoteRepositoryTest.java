package com.hiepnd.mailer.repository;

import static org.junit.Assert.*;

import androidx.lifecycle.LiveData;

import com.hiepnd.mailer.model.Quote;
import com.hiepnd.mailer.model.QuoteResponse;
import com.hiepnd.mailer.service.FakeQuoteService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class QuoteRepositoryTest {
    private QuoteRepository quoteRepository;

    // A JUnit Test Rule that swaps the background executor used by the Architecture Components with a different one which executes each task synchronously.
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    // mock QuoteService by FakeQuoteService
    @Before
    public void createQuoteRepository(){
        quoteRepository = new QuoteRepository(new FakeQuoteService());
    }


    @Test
    public void getQuotes(){
        LiveData<QuoteResponse> quoteResponse = quoteRepository.getQuotes();

        if(quoteResponse.getValue()!=null){
            assertEquals(quoteResponse.getValue().getQuoteContents().getQuotes().get(0).getQuote(), "Fake Quote");
        }
    }
}