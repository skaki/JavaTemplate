package skTest;

import org.apache.log4j.Logger;


public class Worker extends Thread {
	static final Logger log = Logger.getLogger(Worker.class.getName());
	private String [] payload = null;
	
	public Worker(String [] line) {
		payload = line;
	}
	
	public void run()
	{
    	try { 
    		String p1 =  payload[0];
			String p2 = payload[1];
			String p3 = payload[2];
		
			log.debug("p1 =" + p1 + ",p2 =" + p2 + ",p3 =" + p3 );
    		Aggregator.recordWork();
    		
    	} catch (Exception e) {
    		log.debug("Worker Error: ", e );
    	} 
	}
}
