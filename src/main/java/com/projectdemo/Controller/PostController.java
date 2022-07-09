package com.projectdemo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectdemo.entity.IdObject;
import com.projectdemo.entity.Posts;
import com.projectdemo.Services.PostService;
import com.projectdemo.Services.ResponseObjectService;

@RestController
//@RequestMapping("/postservice")
public class PostController {	
	
	@Autowired
	PostService postservice;
	
	@PostMapping("/insertpost")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> insrtpost(@RequestBody Posts inputpost){
		return new ResponseEntity<ResponseObjectService>(postservice.insertpost(inputpost),HttpStatus.OK);
	}
	
	@PostMapping("/getposts")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> getallpost(@RequestBody IdObject id) throws Exception{
		System.out.println(id.getId());
		return new ResponseEntity<ResponseObjectService>(postservice.findpostbyid(id),HttpStatus.OK);
	}
	
	@PostMapping("/feed")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> getfollowerposts(@RequestBody IdObject id) throws Exception{
		System.out.println("cricket");
		return new ResponseEntity<ResponseObjectService>(postservice.findpostoffollowers(id),HttpStatus.OK);
	}
}