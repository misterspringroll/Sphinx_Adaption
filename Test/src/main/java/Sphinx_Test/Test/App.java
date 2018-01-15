package Sphinx_Test.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		  Logger cmRootLogger = Logger.getLogger("default.config");
		  cmRootLogger.setLevel(java.util.logging.Level.OFF);
		  String conFile = System.getProperty("java.util.logging.config.file");
		  if (conFile == null) {
		        System.setProperty("java.util.logging.config.file", "ignoreAllSphinx4LoggingOutput");
		  }
		 Configuration configuration = new Configuration();
		//configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setAcousticModelPath("file:E:/workspace/Sphinx_Test/Test/resource/en-us-adapt-google");
		//configuration.setAcousticModelPath("file:E:/workspace/Sphinx_Test/Test/resource/en-us-adapt");
	     configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
	     configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
	     PrintWriter writer = new PrintWriter("default en-us origin Origin Sample Test.txt", "UTF-8");
	     StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
		File folder = new File("resource/test data/origin");
	    //File folder = new File("C:/Users/Admin/Desktop/New Recordings/James New Recording's/Noise Background");
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        String file_name = "C:/Users/Admin/Desktop/test_data/origin/" + listOfFiles[i].getName();
		        System.out.println("[Original] Processing " + file_name);
		        InputStream stream = new FileInputStream(new File(file_name));
		        writer.println(file_name);
		        recognizer.startRecognition(stream);
		    	SpeechResult result;
		            while ((result = recognizer.getResult()) != null) {
		            	 writer.println(result.getHypothesis());
		    	}
		    	recognizer.stopRecognition();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		writer.close();
		writer = new PrintWriter("default en-us origin Weiner Sample Test.txt", "UTF-8");
		folder = new File("resource/test data/weiner");
	    //File folder = new File("C:/Users/Admin/Desktop/New Recordings/James New Recording's/Noise Background");
		listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        String file_name = "C:/Users/Admin/Desktop/test_data/weiner/" + listOfFiles[i].getName();
		        System.out.println("[Weiner] Processing " + file_name);
		        InputStream stream = new FileInputStream(new File(file_name));
		        writer.println(file_name);
		        recognizer.startRecognition(stream);
		    	SpeechResult result;
		            while ((result = recognizer.getResult()) != null) {
		            	 writer.println(result.getHypothesis());
		    	}
		    	recognizer.stopRecognition();
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		writer.close();

    }
}
