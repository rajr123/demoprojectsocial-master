package com.projectdemo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectdemo.entity.UserSignInEntity;
import com.projectdemo.Repository.FollowersRepository;
import com.projectdemo.Repository.UserRepository;
import com.projectdemo.Services.ResponseObjectService;
import com.projectdemo.Services.UserService;
import com.projectdemo.entity.DoubleIdObject;
import com.projectdemo.entity.IdObject;
import com.projectdemo.entity.User;
import com.projectdemo.entity.UsernameObject;
@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
    private UserRepository userRepo;
	@Autowired
	private FollowersRepository followerrepo;
	@RequestMapping("/users")  
    public String hello(){  return "Hello user";  }  
	
	@PostMapping("users/save")
    public ResponseEntity<ResponseObjectService> saveUser(@RequestBody User inputUser) {
        return new ResponseEntity<ResponseObjectService>(userService.saveUser(inputUser), HttpStatus.OK);
    }
	
	@PostMapping("/users/signin")
	@ResponseBody
    public ResponseEntity<ResponseObjectService> userSignIn(@RequestBody UserSignInEntity inputUser) {
		ResponseObjectService resobj = new ResponseObjectService();
		List<User> optUser = userRepo.getuserbymailid(inputUser.getEmail());
		if(optUser.size() == 0) {
			resobj.setStatus("fail");
			resobj.setMessage("Email id does not exist");
			resobj.setUserdetail(null);
			
		}
		else {
			User user = optUser.get(0);
			String pass1 =  user.getPassword();
			String pass2 = inputUser.getPassword();
			
			if(pass1.equals(pass2)) {
				
				resobj.setStatus("success");
				resobj.setMessage("success");
				resobj.setUserdetail(user.getUsername());
				
			}
			else {
				resobj.setStatus("fail");
				resobj.setMessage("Wrong password");
				resobj.setUserdetail(null);
			}
		}
		return new ResponseEntity<ResponseObjectService>(resobj, HttpStatus.OK);  
    }
	@PostMapping("/users/profile")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> findByUsername(@RequestBody UsernameObject username) {
	    return new ResponseEntity<ResponseObjectService>(userService.findByUsername(username.getUsername()), HttpStatus.OK);
	}
	
	@PostMapping("/followinglist")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> followerlist(@RequestBody IdObject id) {
	    return new ResponseEntity<ResponseObjectService>(userService.followerslst(id), HttpStatus.OK);
	}
	
	@PostMapping("/followerlist")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> followinglist(@RequestBody IdObject id) {
	    return new ResponseEntity<ResponseObjectService>(userService.followinglst(id), HttpStatus.OK);
	}
	
	@PostMapping("/follow")
	@ResponseBody
	public ResponseEntity<ResponseObjectService> follow(@RequestBody DoubleIdObject id) {
	    return new ResponseEntity<ResponseObjectService>(userService.followuser(id), HttpStatus.OK);
	}
	
}




