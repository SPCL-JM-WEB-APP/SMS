package com.springjava.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springjava.dto.Detail_Dao;
import com.springjava.entity.Detail_entity;
import com.springjava.entity.Fees_Collection_entity;

public interface AccountServices

{
	
	Optional<Fees_Collection_entity> findById(int Student_id);

	List<Detail_entity> getAllDetails();
	
	void saveEntity(Detail_entity entity);

   void removeFee(int index);
    
	Optional<Detail_entity> findFeeById(int feeId);

	List<Fees_Collection_entity> getAllStudents();
	
	Fees_Collection_entity getStudentById(int Student_id);
	static void collectFees(Detail_entity feeCollection) {
		
	}

}
