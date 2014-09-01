package skTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class Aggregator {
	static final Logger log = Logger.getLogger(Aggregator.class.getName());
	static int rowsProcessed = 0;	
	
	public static synchronized int recordWork() {
		
	    try {
			OutputStream os = new FileOutputStream("test.out", true);
			String s = String.valueOf(++rowsProcessed) + "\n";
			os.write( s.getBytes("US-ASCII") );
		    os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // writes the bytes
	      
		return rowsProcessed;
		
	}
	
	public static synchronized int publishWork() {
		return rowsProcessed;
	}

	public static synchronized void reset() {
		rowsProcessed = 0;
	}

}
