package com.projectdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectdemo.entity.Comments;

@Repository
public interface CommentsRepository extends CrudRepository<Comments,Integer>{
	
}
