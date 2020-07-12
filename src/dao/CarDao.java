package dao;


import java.util.List;
import java.util.Optional;

import dao.entity.CarEntity;
import dao.entity.TimeEntity;


public interface CarDao {
	String save(CarEntity entity);
	List<CarEntity> findAll();
	Optional<CarEntity> findLoginUser(String userid, String password);
	int deleteByEmailId(String userid);
	CarEntity findprofile(String userid);
	void update(String userid, String name, String model, String color, String vendor, long price);
	List<TimeEntity> findTime();
	
	

}
