package com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades.springdatajpa.GradesJpaRepository;




@Service
public class GradesService {

	@Autowired
	  GradesJpaRepository repository;
	
	public void save(MultipartFile file) {
	    try {
	    	System.out.println("in try 2");
	      List<Grades> GradesData = GradesHelper.csvToGradesData(file.getInputStream());
	      System.out.println("in try 3");
	      repository.saveAll(GradesData);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	
	public List<Grades> getAllGrades() {
	    return repository.findAll();
	  }
}
