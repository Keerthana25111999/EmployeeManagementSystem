package com.datarest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.datarest.entities.Compliance;
import com.datarest.entities.StatusReport;

@Repository
public interface IComplianceRepository extends JpaRepository<Compliance, Integer> {
	
	void save(StatusReport statusreport);
	
	@Query("Select c from Compliance c join c.statusreport s join s.employee e where e.userId = ?1")
	List<Compliance> findByUserId(int userId);
	
	@Query("Select s from StatusReport s join s.employee e where e.userId =?1 and s.complianceId=?2")
	List<StatusReport> findStatusReportById(int userId, int compid);

}
