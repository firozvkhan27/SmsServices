package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.InputRequest;
import com.sms.service.SortService;

@RestController
@RequestMapping(value="/api/v1/sms/sort")
public class SortController {
	@Autowired
	private SortService sortService;
	/**
	 * Method used for Sorting the dataBase basis on the parameter
	 * @param tag  String parameter
	 * @return list
	 */
	@GetMapping("/{tag}")
	public List<InputRequest> sortBy(@PathVariable("tag")final String tag)  {
		return sortService.sortByTag(tag);
	}
}
