package com.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sms.domain.DataDomain;
import com.sms.model.InputRequest;
import com.sms.repository.DataRepository;
import com.sms.util.SmsUtil;

@Service
public class SortService {
	@Autowired
	private DataRepository dataRepository;

	/**
	 * Method used for Sorting the dataBase basis on the parameter
	 * @param tag  String parameter
	 * @return list
	 */
	public List<InputRequest> sortByTag(final String tag) {
	List<DataDomain> userList = dataRepository.findAll(Sort.by(Sort.Direction.ASC, tag));
	List<InputRequest> response = new ArrayList<>();
	userList.forEach(it->{
		InputRequest ir = new InputRequest();
		ir.setId(it.getId());
		ir.setCity(it.getCity());
		ir.setEnd_date(SmsUtil.convertDateToString(it.getEndDate()));
		ir.setStart_date(SmsUtil.convertDateToString(it.getStartDate()));
		ir.setPrice(it.getPrice().toString());
		ir.setColor(it.getColor());
		ir.setStatus(it.getStatus());
		response.add(ir);
	});
	
	return response;
	}

}
