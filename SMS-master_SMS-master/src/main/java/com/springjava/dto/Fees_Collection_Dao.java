package com.springjava.dto;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springjava.entity.Fees_Collection_entity;


//import com.rt.springboot.entity.Fees_Collection_entity;
public interface Fees_Collection_Dao extends JpaRepository<Fees_Collection_entity, Integer>

{

//	void removeFee(int index);
//
//	void saveEntity(Detail_entity entity);
//
//	List<Detail_entity> getAllDetails();


	}
