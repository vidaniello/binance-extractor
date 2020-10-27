package com.github.vidaniello.binance.extractor;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.apache.commons.csv.CSVFormat;
import org.junit.Assert;
import org.junit.Test;

import com.binance.api.client.domain.market.CandlestickInterval;




public class TestOne {

    @Test
	public void testOne() {
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintWriter pw = new PrintWriter(baos);
			new Extractor().extractKlines(pw, CSVFormat.DEFAULT.withQuote(null), "INJBUSD", CandlestickInterval.DAILY);
			pw.close();
			String csv = baos.toString();
			Assert.assertTrue(!csv.isEmpty());
		} catch (Exception e) {
			throw new AssertionError(e);
		}
		
	}

}
