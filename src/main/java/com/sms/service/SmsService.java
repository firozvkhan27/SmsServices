package com.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.domain.DataDomain;
import com.sms.exception.SmsException;
import com.sms.model.InputRequest;
import com.sms.repository.DataRepository;
import com.sms.util.SmsUtil;

@Service
public class SmsService {
	@Autowired
	private DataRepository dataRepository;

	public List<InputRequest> getAllData() throws SmsException {
		try {
			List<DataDomain> findAll = dataRepository.findAll();
			List<InputRequest> response = new ArrayList<>();
			findAll.forEach(it -> {
				InputRequest ir = convertToResponse(it);
				response.add(ir);
			});

			return response;
		} catch (Exception e) {
			throw new SmsException("Something Went wrong while fetching");
		}
	}

	public void saveData(final List<InputRequest> data) throws SmsException {
		try {
			data.stream().forEach(it -> {
				DataDomain dd = convertToDomain(it);
				dataRepository.save(dd);
			});
		} catch (Exception e) {
			throw new SmsException("Something Went wrong while Saving");
		}
	}

	public List<InputRequest> getDataByDates(final String startDate,
			final String enddate) throws SmsException {
		try {
			List<DataDomain> fetchDateRange = dataRepository.fetchDateRange(
					SmsUtil.convertStringDate(startDate),
					SmsUtil.convertStringDate(enddate));
			List<InputRequest> response = new ArrayList<>();
			fetchDateRange.forEach(it -> {
				InputRequest ir = convertToResponse(it);
				response.add(ir);
			});
			return response;
		} catch (Exception e) {
			throw new SmsException(
					"Something Went wrong while fetching by given dates");
		}
	}

	public List<InputRequest> deleteById(final Integer id) throws SmsException {
		try {
			dataRepository.deleteById(id);
			List<DataDomain> findAll = dataRepository.findAll();
			List<InputRequest> response = new ArrayList<>();
			findAll.forEach(it -> {
				InputRequest ir = convertToResponse(it);
				response.add(ir);
			});
			return response;
		} catch (Exception e) {
			throw new SmsException("Something Went wrong while deleting");
		}
	}

	public List<InputRequest> updateData(final InputRequest data)
			throws SmsException {
		try {
			DataDomain dd = convertToDomain(data);
			dataRepository.save(dd);
			List<DataDomain> findAll = null;
			if (data.getSelectEndDateRange().length() > 6
					&& data.getSelectStartDateRange().length() > 6) {
				findAll = dataRepository.fetchDateRange(SmsUtil
						.convertStringDate(data.getSelectStartDateRange()),
						SmsUtil.convertStringDate(data.getEnd_date()));
			} else {
				findAll = dataRepository.findAll();
			}

			List<InputRequest> response = new ArrayList<>();
			findAll.forEach(it -> {
				InputRequest ir = convertToResponse(it);
				response.add(ir);
			});
			return response;
		} catch (Exception e) {
			throw new SmsException("Something Went wrong while Updating");
		}

	}

	private DataDomain convertToDomain(final InputRequest data) {
		DataDomain dd = new DataDomain();
		dd.setId(data.getId());
		dd.setCity(data.getCity());
		dd.setColor(data.getColor());
		dd.setPrice(Double.parseDouble(data.getPrice()));
		dd.setStatus(data.getStatus());
		dd.setStartDate(SmsUtil.convertStringDate(data.getStart_date()));
		dd.setEndDate(SmsUtil.convertStringDate(data.getEnd_date()));
		return dd;
	}

	private InputRequest convertToResponse(final DataDomain it) {
		InputRequest ir = new InputRequest();
		ir.setId(it.getId());
		ir.setCity(it.getCity());
		ir.setEnd_date(SmsUtil.convertDateToString(it.getEndDate()));
		ir.setStart_date(SmsUtil.convertDateToString(it.getStartDate()));
		ir.setPrice(it.getPrice().toString());
		ir.setColor(it.getColor());
		ir.setStatus(it.getStatus());
		return ir;
	}

}
