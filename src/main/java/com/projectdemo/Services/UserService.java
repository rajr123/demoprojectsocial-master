package com.projectdemo.Services;
import java.util.*;

import com.projectdemo.entity.DoubleIdObject;
import com.projectdemo.entity.Followers;
import com.projectdemo.entity.IdObject;
import com.projectdemo.entity.User;
import com.projectdemo.Repository.UserRepository;
import com.projectdemo.Repository.FollowersRepository;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/

import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userrepo;
    @Autowired
    FollowersRepository followerrepo;

    public ResponseObjectService saveUser(User userdetail) {
    	ResponseObjectService resobj = new ResponseObjectService();
		List<User> checkusr=userrepo.getuserbymailid(userdetail.getEmail());
		List<User> checkusrname=userrepo.getusername(userdetail.getUsername());
		System.out.println(checkusr);
		System.out.println(checkusrname);
		if(checkusr.size()==0 && checkusrname.size()==0) {
			User user=userrepo.save(userdetail);
			resobj.setStatus("success");
            resobj.setMessage("success");
            resobj.setUserdetail(user);
            return resobj;
		}
		else if(checkusr.size()!=0){
			resobj.setStatus("fail");
            resobj.setMessage("allready created an account with Email address :"+userdetail.getEmail());
            resobj.setUserdetail(null);
            return resobj;
		}
		else{
			resobj.setStatus("fail");
            resobj.setMessage("allready created an account with username :"+userdetail.getUsername());
            resobj.setUserdetail(null);
            return resobj;
		}
		
	}
    
    
    
    public ResponseObjectService findByUsername(String username) {
        ResponseObjectService responseObj = new ResponseObjectService();
        List<User> optUser = userrepo.getusername(username);
        if (optUser.size() == 0) {
            responseObj.setStatus("fail");
            responseObj.setMessage("user id: " + username + " not existed");
            responseObj.setUserdetail(null);
            return responseObj;
        } else {
            responseObj.setUserdetail(optUser.get(0));
            responseObj.setStatus("success");
            responseObj.setMessage("success");
            return responseObj;
        }
    }
    public ResponseObjectService followerslst(IdObject id) {
        ResponseObjectService responseObj = new ResponseObjectService();
        List<String> followerlist=followerrepo.getallfollowers(id.getId());
        if(followerlist.size()==0) {
        	responseObj.setStatus("fail");
            responseObj.setMessage("not following anyone yet");
            responseObj.setUserdetail(null);
            return responseObj;
        }
        else {
            responseObj.setUserdetail(followerlist);
            responseObj.setStatus("success");
            responseObj.setMessage("Followerslist");
            return responseObj;
        }
    }
    public ResponseObjectService followinglst(IdObject id) {
        ResponseObjectService responseObj = new ResponseObjectService();
        List<String> followinglist=followerrepo.getfollowing(id.getId());
        if(followinglist.size()==0) {
        	responseObj.setStatus("fail");
            responseObj.setMessage("no followers yet");
            responseObj.setUserdetail(null);
            return responseObj;
        }
        else {
            responseObj.setUserdetail(followinglist);
            responseObj.setStatus("success");
            responseObj.setMessage("Followinglist");
            return responseObj;
        }
    }
    public ResponseObjectService followuser(DoubleIdObject doubleid) {
		ResponseObjectService resobj=new ResponseObjectService();
		User followeruserdetails=userrepo.getuserbyid(doubleid.getId1());
		User followedetails=userrepo.getuserbyid(doubleid.getId2());
		if(followeruserdetails==null || followedetails==null) {
			resobj.setStatus("fail");
			resobj.setMessage("No user id");
			resobj.setUserdetail(null);
			return resobj;
		}
		else {
			Followers followedfollowerdetail=new Followers();
			followedfollowerdetail.setFusername(doubleid.getId1());
			followedfollowerdetail.setUsern(doubleid.getId2());
			followerrepo.save(followedfollowerdetail);
			resobj.setStatus("Success");
			resobj.setMessage(followedfollowerdetail.getFusername()+" follows "+followedfollowerdetail.getUsern());;
			resobj.setUserdetail(followedfollowerdetail);
			return resobj;
		}
	}

        
}


