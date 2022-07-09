package com.projectdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projectdemo.entity.LikedBy;

@Repository
public interface LikedByRepository extends CrudRepository<LikedBy,Integer>{

}
