package com.persistent.aicrew.repository;

import com.persistent.aicrew.dao.entity.Bill;
import com.persistent.aicrew.dao.entity.Claim;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Integer>{
	
}
