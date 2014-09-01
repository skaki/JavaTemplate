package skTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;


/*
 * java -cp target/skTest-0.0.1-SNAPSHOT.jar skTest.Driver -csv test.csv
 */

public class Driver {
	
	static final Logger log = Logger.getLogger(Driver.class.getName());

	public static void main(String args[]) {
		
		Options options = new Options();
    	
    	options.addOption("csv", true, "csv file name");
    	
		CommandLineParser parser = new BasicParser();
		
		CommandLine cmd;
		try {
			cmd = parser.parse( options, args);
			String fileName = cmd.getOptionValue("csv");
			log.debug("CSV file Name " +  fileName );
			if ( fileName != null ) {
				CSVReader reader = new CSVReader(new FileReader(fileName));
				String [] nextLine = reader.readNext();
				while ((nextLine = reader.readNext()) != null) {
	    			Worker w = new Worker(nextLine);
	    			w.start();
	    			try {
						w.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.debug("Main Complete, Rows processed : " + Aggregator.rowsProcessed);
	}
}
