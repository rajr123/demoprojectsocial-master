package com.projectdemo.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectdemo.entity.Posts;



@Repository
public interface PostsRepository extends CrudRepository<Posts,Integer>{
	@Query(value="select * from Posts where user=:username",nativeQuery=true)
	public List<Posts> findpostbyid(@Param("username") String id);
	
}
