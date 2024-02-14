package account.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import account.demo.entity.Detail_entity;

//import com.rt.springboot.entity.Detail_entity;

public interface Detail_Dao extends JpaRepository<Detail_entity, Integer> {

	//com.rt.springboot.entity.Detail_entity save(com.rt.springboot.entity.Detail_entity entity);

	
	//void saveDetail(Detail_entity detail);

}
