package com.github.vidaniello.binance.extractor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileUtil {
	
	
	public static void save(String filename, byte[] data) throws IOException {
		
		File file = new File(filename);
		if(file.exists())
			file.delete();
		file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		
		IOUtils.copy(bais, fos);
		
		fos.close();
		bais.close();
			
	}

}
