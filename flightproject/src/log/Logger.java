package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static Logger log ;
	private static final String FILE_NAME = "infos.log";
	private static File logFile;
	private Logger() {
		
	}
	
	static {
		URL resource = Logger.class.getClassLoader().getResource(FILE_NAME);
		try {
			logFile = new File(resource.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static Logger getLogger() {
		if (log == null) {
			return log;
		}
		log = new Logger();
		return log;
	}

	
	public void log(String text) {
		FileWriter writer = null;
		BufferedWriter bw = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			writer = new FileWriter(logFile,true);
			bw = new BufferedWriter(writer);
			bw.write(format.format(new Date())+" :"+text);
			bw.newLine();
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
