package com.projectdemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectdemo.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	@Query(value="select * from User where email=:mailid",nativeQuery=true)
	public List<User> getuserbymailid(@Param("mailid") String email);
	
	@Query(value="select * from User where username=:usrname",nativeQuery=true)
	public User getuserbyid(@Param("usrname") String email);
	
	@Query(value="select * from User where username=:usrname",nativeQuery=true)
	public List<User> getusername(@Param("usrname") String username);
}
