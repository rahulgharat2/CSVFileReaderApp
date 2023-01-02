package com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HarbingerGroup.CSVFileReader.CSVFileReaderApp.grades.Grades;

public interface GradesJpaRepository extends JpaRepository<Grades, Long>{

	//List<Grades> findByAuthor(String author);
}

