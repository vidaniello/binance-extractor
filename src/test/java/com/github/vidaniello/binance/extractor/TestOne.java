package com.github.vidaniello.binance.extractor;

import org.junit.Test;


public class TestOne {

    @Test
	public void testOne() {
		
		try {
			new Extractor().extractOldTrade();
			
		} catch (Exception e) {
			throw new AssertionError(e);
		}
		
	}

}
