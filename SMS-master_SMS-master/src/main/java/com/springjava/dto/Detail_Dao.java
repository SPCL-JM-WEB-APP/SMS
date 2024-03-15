package com.springjava.dto;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springjava.entity.Detail_entity;

//import com.rt.springboot.entity.Detail_entity;

public interface Detail_Dao extends JpaRepository<Detail_entity, Integer> {

	//com.rt.springboot.entity.Detail_entity save(com.rt.springboot.entity.Detail_entity entity);

	
	//void saveDetail(Detail_entity detail);

}
