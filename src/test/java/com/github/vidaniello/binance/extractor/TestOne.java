package com.github.vidaniello.binance.extractor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.csv.CSVFormat;
import org.junit.Assert;
import org.junit.Test;

import com.binance.api.client.domain.market.CandlestickInterval;




public class TestOne {

    @Test
	public void testOne() {
		
		try {
			String symbol = "INJBUSD";
			CandlestickInterval interval = CandlestickInterval.HOURLY;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintWriter pw = new PrintWriter(baos);
			new Extractor().extractKlines(pw, CSVFormat.DEFAULT.withQuote(null), symbol, interval);
			pw.close();
			String csv = baos.toString();
			Assert.assertTrue(!csv.isEmpty());
			String filename = System.getProperty("user.home")+"/"+symbol+"_"+interval.getIntervalId()+".csv";
			FileUtil.save(filename, baos.toByteArray());
			Assert.assertTrue(new File(filename).exists());
		} catch (Exception e) {
			throw new AssertionError(e);
		}
		
	}

}
