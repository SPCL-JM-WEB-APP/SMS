package com.springjava.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjava.dto.Detail_Dao;
import com.springjava.dto.*;
import com.springjava.entity.Detail_entity;
import com.springjava.entity.Fees_Collection_entity;
import com.springjava.service.AccountServices;

@Service
public class AccountServiceImpl implements AccountServices
{ 
	private final Fees_Collection_Dao fees;
	private final Detail_Dao detailDao;
	
	 @Autowired
	    public AccountServiceImpl(Detail_Dao detailDao, Fees_Collection_Dao fees) {
	        this.detailDao = detailDao;
	        this.fees = fees;
	    }
   
@Override
     public Optional<Fees_Collection_entity> findById(int Student_id) {
    return fees.findById(Student_id);
}

	@Override
	public List<Detail_entity> getAllDetails() {
		// TODO Auto-generated method stub
		return detailDao.findAll();
	}

	@Override
	public void saveEntity(Detail_entity entity) {
		// TODO Auto-generated method stub
		detailDao.save(entity);
		
	}

	@Override
	public void removeFee(int index) {
		// TODO Auto-generated method stub
	   // detailDao.deleteById(feeId);

	}

	@Override
	public Optional<Detail_entity> findFeeById(int feeId) {
		// TODO Auto-generated method stub
		return detailDao.findById(feeId);
	}

	public List<Fees_Collection_entity> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fees_Collection_entity getStudentById(int Student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Detail_entity> getDetailsByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

//	public Optional<Fees_Collection_entity> getAllStudents(int Student_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}

