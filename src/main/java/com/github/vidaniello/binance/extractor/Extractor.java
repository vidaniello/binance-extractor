package com.github.vidaniello.binance.extractor;

import java.util.List;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.impl.BinanceApiService;

public class Extractor {
	
	
	public void extractOldTrade() {
		try {
			String apiKey = System.getProperty("apikey");
			String secret = System.getProperty("secret");
			BinanceApiRestClient client = BinanceApiClientFactory.newInstance(apiKey,secret).newRestClient();
			List<TradeHistoryItem> trades = client.getHistoricalTrades("INJBUSD", null, 0l);
			
			
			
			int i = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
