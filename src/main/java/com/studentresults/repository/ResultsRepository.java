package com.studentresults.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentresults.entity.Results;

public interface ResultsRepository extends JpaRepository<Results, Integer> {
	@Query(value="select name from results where percentage=(select max(percentage) from results)",nativeQuery=true)
	String getTopper();
	@Query(value="select name from results order by percentage desc limit 3",nativeQuery=true)
	List<String> getTop3();
	@Query(value="select name from results where percentage>85 and percentage<=90",nativeQuery=true)
	List<String> getByRange();

}
