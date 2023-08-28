package com.studentresults.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.studentresults.entity.MarkSheet;
import com.studentresults.entity.Results;
import com.studentresults.entity.Student;
import com.studentresults.service.ResultsService;

@RestController
public class ResultsController {
@Autowired
RestTemplate rt;
@Autowired
ResultsService rs;
@GetMapping("/getStudent")
public List<Student> getStudent() {
	String url="http://localhost:8080/getAll";
	ResponseEntity<List<Student>> r=rt.exchange(url, HttpMethod.GET, null,new ParameterizedTypeReference<List<Student>>() {});
	List<Student> s=r.getBody();
	return s;
}
@GetMapping("/getMarkSheet")
public List<MarkSheet> getMarkSheet() {
	String url="http://localhost:8081/getAll";
	ResponseEntity<List<MarkSheet>> r=rt.exchange(url,HttpMethod.GET, null,new ParameterizedTypeReference<List<MarkSheet>>() {});
	List<MarkSheet> s=r.getBody();
	return s;
}
@GetMapping("/getResults")
public List<Results> getResults() {
	List<Student> a=getStudent();
	List<MarkSheet> b=getMarkSheet();

	
	List<Results> res = new ArrayList<>();
	
	for(int i=0; i< a.size(); i++) {
		int id = a.get(i).getId();
		String name = a.get(i).getName();
		int rollNumber = a.get(i).getRollNumber();
		int totalMarks=0;
		if(a.get(i).getAttendance()>90) {
		totalMarks = 5+((b.get(i).getSem1Total()+b.get(i).getSem2Total())/2);
		}
		else {
		totalMarks=(b.get(i).getSem1Total()+b.get(i).getSem2Total())/2;
		}
		int percentage = totalMarks/2;
		
		res.add(new Results(id, name, rollNumber, totalMarks, percentage));
		
	}
	
	return res;
	
}
@PostMapping("/setResults")
public String setResults() {
	List<Results> a=getResults();
	return rs.setResults(a);
}
@GetMapping("/getTopper")
public String getTopper() {
	return rs.getTopper();
}
@GetMapping("/getTop3")
public List<String> getTop3() {
	return rs.getTop3();
}
@GetMapping("/getByRange")
public List<String> getByRange() {
	return rs.getByRange();
}
}
