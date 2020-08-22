package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.InputRequest;
import com.sms.service.SmsService;

@RestController
@RequestMapping(value="/api/v1/sms")
public class SmsController {
	@Autowired
	private SmsService service;
	
	/**
	 * Api to Save all the data present in the data.json in given problem statement
	 * @return List of response
	 */
	@PostMapping()
	public boolean save(@RequestBody final List<InputRequest> data)  {
		service.saveData(data);
		return true;
	}
	/**
	 * Api to Update data 
	 * @return List of response
	 */
	@PutMapping()
	public List<InputRequest> update(@RequestBody final InputRequest data)  {
		return service.updateData(data);
	}
	/**
	 * Api to Delete data Basis on the Id
	 * @return List of response
	 */
	@DeleteMapping("/{id}")
	public List<InputRequest>  delete(@PathVariable("id") final Integer id) throws Exception {
		return service.deleteById(id);
	}
	
	
	/**
	 * Api to Fetch alldata from the database
	 * @return List of response
	 */
	@GetMapping("/all")
	public  List<InputRequest> getAll()  {
		return service.getAllData();
	}
	/**
	 * Api to Fetch data Basis on the selected dates
	 * @return List of response
	 */
	@GetMapping("/selectRange")
	public  List<InputRequest> filterByDates(@RequestParam("start_date")final String startDate,@RequestParam("end_date") final String end_date)  {
		return service.getDataByDates(startDate,end_date);
	}
	
	
	
	
	
}
