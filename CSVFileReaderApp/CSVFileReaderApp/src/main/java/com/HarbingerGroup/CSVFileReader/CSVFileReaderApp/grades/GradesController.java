package com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/csv")
public class GradesController {

	 @Autowired
	  GradesService fileService;
	 
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (GradesHelper.hasCSVFormat(file)) {
	      try {
	    	  System.out.println("in try");
	        fileService.save(file);

	       // message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	      

	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,"hello"));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
	  }

	  @GetMapping("/grades")
	  public ResponseEntity<List<Grades>> getAllGrades() {
	    try {
	      List<Grades> GradesData = fileService.getAllGrades();

	      if (GradesData.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(GradesData, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
