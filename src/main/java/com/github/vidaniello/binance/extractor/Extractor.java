package com.github.vidaniello.binance.extractor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;

public class Extractor {
	
	
	//List<TradeHistoryItem> trades = client.getHistoricalTrades("INJBUSD", null, 0l);
	
	private BinanceApiRestClient client;
	private BinanceApiRestClient getRestClient() {
		if(client==null) {
			String apiKey = System.getProperty("apikey");
			String secret = System.getProperty("secret");
			client = BinanceApiClientFactory.newInstance(apiKey,secret).newRestClient();
		}
		return client;
	}
	
	public static final String[] candleStickHeader = new String[] {
			"openTime", "open", "high", "low", "close", "closeTime", "volume", 
			"quoteAssetVolume", "numberOfTrades", "takerBuyBaseAssetVolume", "takerBuyQuoteAssetVolume"};
	/**
	 * Last 500 candleStick to outputStream in csvFormat
	 * @param os
	 * @param symbol
	 * @param interval
	 */
	public void extractKlines(Appendable outputStream, CSVFormat csvFormat, String symbol, CandlestickInterval interval) {
		try {
			
			
			List<Candlestick> candles = getRestClient().getCandlestickBars(symbol, interval);
			
			CSVPrinter csvPrinter = new CSVPrinter(outputStream, csvFormat.withHeader(candleStickHeader));
			
			candles.forEach(candle->{
				try {
					csvPrinter.printRecord(
							candle.getOpenTime().toString(),
							candle.getOpen(),
							candle.getHigh(),
							candle.getLow(),
							candle.getClose(),
							candle.getCloseTime().toString(),
							candle.getVolume(),
							candle.getQuoteAssetVolume(),
							candle.getNumberOfTrades().toString(),
							candle.getTakerBuyBaseAssetVolume(),
							candle.getTakerBuyQuoteAssetVolume()
							);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			int i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
