package com.persistent.aicrew.service;

import com.persistent.aicrew.dao.entity.Bill;
import com.persistent.aicrew.dao.entity.Claim;
import com.persistent.aicrew.repository.BillRepository;
import com.persistent.aicrew.repository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;


	public List<Bill> getBills() {
		List<Bill> result = new ArrayList<>();
		billRepository.findAll().forEach(result::add);
		return result;
	}
}
