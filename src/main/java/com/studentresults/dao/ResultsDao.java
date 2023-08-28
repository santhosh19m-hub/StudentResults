package com.studentresults.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentresults.entity.Results;
import com.studentresults.repository.ResultsRepository;
@Repository
public class ResultsDao {
@Autowired
ResultsRepository rr;
	public String setResults(List<Results> a) {
		rr.saveAll(a);
		return "Success";
	}
	public String getTopper() {
		return rr.getTopper();
	}
	public List<String> getTop3() {
		return rr.getTop3();
	}
	public List<String> getByRange() {
		return rr.getByRange();
	}

}
