package com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;





public class GradesHelper {
	  public static String TYPE = "text/csv";
	 // static String[] HEADERs = { "Id", "First_name", "Lats_name", "Ssn","Test1","Test2","Test3","Test4","Final_test","Grade"};

	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }

	  public static List<Grades> csvToGradesData(InputStream is) {
	    try { BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	    	CSVReader reader=new CSVReader(fileReader,',','\'',1);
	    	
	    	String[]nextLine;
	    	
	    
	    	List<Grades> GradesDataList=new ArrayList<>();
	    	
	    	while((nextLine=reader.readNext()) !=null) {
	    		Grades grades=new Grades(
	    				Long.parseLong(nextLine[0]),
	    				nextLine[1],
	    				nextLine[2],
	    				nextLine[3],
	    				Double.parseDouble(nextLine[4]),
	    				Double.parseDouble(nextLine[5]),
	    				Double.parseDouble(nextLine[6]),
	    				Double.parseDouble(nextLine[7]),
	    				Double.parseDouble(nextLine[8]),
	    				nextLine[9]
	    				);
	    		
	    		
	    		GradesDataList.add(grades);
	    	}
	    	
	    	 System.out.println("passed");
	    	 
	      
	     
	      return GradesDataList;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }


	}