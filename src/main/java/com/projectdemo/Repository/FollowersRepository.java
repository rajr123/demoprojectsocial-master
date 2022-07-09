package com.projectdemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectdemo.entity.Followers;

@Repository
public interface FollowersRepository extends CrudRepository<Followers,Integer>{
	@Query(value="select fusername from Followers where usern=:username",nativeQuery=true)
	public List<String> getallfollowers(@Param("username") String id);

	@Query(value="select usern from Followers where fusername=:username",nativeQuery=true)
	public List<String> getfollowing(@Param("username") String id);
}
