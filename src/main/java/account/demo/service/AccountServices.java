package account.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import account.demo.dao.Detail_Dao;
import account.demo.entity.Detail_entity;
import account.demo.entity.Fees_Collection_entity;

public interface AccountServices

{
	
	Optional<Fees_Collection_entity> findById(int Student_id);

	List<Detail_entity> getAllDetails();
	
	void saveEntity(Detail_entity entity);

   void removeFee(int index);
    
	Optional<Detail_entity> findFeeById(int feeId);

	List<Fees_Collection_entity> getAllStudents();

}
