package com.studentresults.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentresults.dao.ResultsDao;
import com.studentresults.entity.Results;
@Service
public class ResultsService {
@Autowired
ResultsDao rd;
	public String setResults(List<Results> a) {
		return rd.setResults(a);
	}
	public String getTopper() {
		return rd.getTopper();
	}
	public List<String> getTop3() {
		return rd.getTop3();
	}
	public List<String> getByRange() {
		return rd.getByRange();
	}

}
