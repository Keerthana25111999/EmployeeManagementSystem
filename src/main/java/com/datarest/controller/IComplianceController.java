package com.datarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datarest.entities.Compliance;
import com.datarest.entities.StatusReport;
import com.datarest.service.IComplianceService;

@RestController
@RequestMapping("/compliance")
public class IComplianceController {
	@Autowired
	IComplianceService compService;
	
	@GetMapping("/{userId}")
	public List<Compliance> getAllRL(@PathVariable int userId)
	{
		return compService.getAllRL(userId);
	}
	
	@GetMapping
	public List<Compliance> getAllRL()
	{
		return compService.getAllRL();
	}
	
	@GetMapping("/{userId}/{compid}")
	public List<StatusReport> getAllStatusReport(@PathVariable int userId,@PathVariable int compid)
	{
		return compService.getAllStatusReport(userId,compid);
	}
	
	@PostMapping
	public void createRL(@RequestBody Compliance co)
	{
		compService.createRL(co);
	}
	
	@PostMapping("/{statusreport}")
	public void createStatusReport(@RequestBody StatusReport statusreport)
	{
		compService.createStatusReport(statusreport);
	}

}