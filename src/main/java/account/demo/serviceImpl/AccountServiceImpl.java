package account.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import account.demo.dao.Detail_Dao;
import account.demo.dao.Fees_Collection_Dao;
import account.demo.entity.Detail_entity;
import account.demo.entity.Fees_Collection_entity;
import account.demo.service.AccountServices;

@Service
public class AccountServiceImpl implements AccountServices
{     @Autowired
	private Fees_Collection_Dao fees;
@Autowired
private Detail_Dao detailDao;
   
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

	public Optional<Fees_Collection_entity> getAllStudents(int Student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	  
}

