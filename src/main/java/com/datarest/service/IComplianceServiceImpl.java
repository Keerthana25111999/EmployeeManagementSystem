package com.datarest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datarest.entities.Compliance;
import com.datarest.entities.StatusReport;
import com.datarest.repository.IComplianceRepository;

@Service
public class IComplianceServiceImpl implements IComplianceService{
	@Autowired
	private IComplianceRepository repository;

	@Override
	public void createRL(Compliance co) 
	{
		repository.save(co);		
	}

	@Override
	public List<Compliance> getAllRL(int userId) 
	{
		return repository.findByUserId(userId);
	}

	@Override
	public List<Compliance> getAllRL() 
	{
		return (List<Compliance>) repository.findAll();
	}

	@Override
	public void createStatusReport(StatusReport statusreport)
	{
		 repository.save(statusreport);
	}	

	@Override
	public List<StatusReport> getAllStatusReport(int userId,int compid) 
	{
		return repository.findStatusReportById(userId,compid);
	}
}