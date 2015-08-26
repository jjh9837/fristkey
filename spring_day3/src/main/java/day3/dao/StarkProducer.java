package day3.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarkProducer {
	private static Logger logger = LoggerFactory.getLogger(StarkProducer.class);
	public StarkProducer(String fileName){
		Properties prop = new Properties();
		prop.setProperty("name", "toni");
		prop.setProperty("age", "30");
		FileOutputStream out;
		try {
			String file = this.getClass().getResource(fileName).getFile();
			out = new FileOutputStream(file);
			prop.store(out, "starks");
			logger.trace("속성 저장 성공{}", prop);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("속성 저장 실패", e);
		}
	}
}
