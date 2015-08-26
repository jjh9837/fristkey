package test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarkConsumer {
	private static Logger logger = LoggerFactory.getLogger(StarkConsumer.class); 
	public StarkConsumer(String filename){
		Properties prop = new Properties();
		String fileName = "/test/starks.properties";
		InputStream input = 
				this.getClass().getResourceAsStream(fileName);
		try{
			prop.load(input);
			logger.trace("속성 읽음{}", prop);
		}catch(IOException e){
			logger.error("속성 읽기 실패" ,e);
		}
	}
}
