package com.hiepnd.mailer.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void isQuoteEqual_identicalProperties_returnFalse(){
        Quote quote1 = new Quote("Title 1", "Quote 1", "Author 1");
        Quote quote2 = new Quote("Title 1", "Quote 1", "Author 1");
        assertEquals(quote1.getQuote(), quote2.getQuote());
        assertNotEquals(quote1, quote2);
    }
}