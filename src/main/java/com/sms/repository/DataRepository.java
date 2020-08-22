package com.sms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.domain.DataDomain;
@Repository
public interface DataRepository extends JpaRepository<DataDomain, Integer>{

	
	@Query(value="SELECT e FROM DataDomain e WHERE e.startDate BETWEEN ?1 AND  ?2 " )
	public List<DataDomain> fetchDateRange(Date startDate, Date endDate);
	
	@Query(value="SELECT d FROM DataDomain d order by ?1 asc")
	public List<DataDomain> sortByColumn(String tag);
}
