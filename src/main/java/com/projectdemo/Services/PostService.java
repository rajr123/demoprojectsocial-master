package com.projectdemo.Services;
import java.time.Instant;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectdemo.	Repository.FollowersRepository;
import com.projectdemo.entity.User;
import com.projectdemo.Repository.PostsRepository;
import com.projectdemo.Repository.UserRepository;
import com.projectdemo.Services.ResponseObjectService;
import com.projectdemo.entity.FeedPosts;
import com.projectdemo.entity.IdObject;
import com.projectdemo.entity.Posts;
@Service
public class PostService {
	
	@Autowired
	UserRepository userdetailsreposiotory;
	@Autowired
	PostsRepository postsrepository;
	@Autowired
	FollowersRepository followersrepository;
	
	public ResponseObjectService insertpost(Posts inputpost) {
		ResponseObjectService resobj=new ResponseObjectService();
		inputpost.setDate(Instant.now());
		resobj.setStatus("Success");
		resobj.setMessage("success");
		resobj.setUserdetail(postsrepository.save(inputpost));
		return resobj;
	}
	
	public ResponseObjectService findpostbyid(IdObject username) {
		ResponseObjectService resobj=new ResponseObjectService();
		List<Posts> userpost = postsrepository.findpostbyid(username.getId());
		System.out.println("hel");
		if(userpost.isEmpty()) {
			System.out.println("hi");
			resobj.setStatus("fail");
			resobj.setMessage("Cannot find any post from user id: "+username.getId());
			resobj.setUserdetail(null);
			return resobj;
		}
		else {
			resobj.setStatus("success");
			resobj.setMessage("success");
			resobj.setUserdetail(userpost);
			return resobj;
		}
	}
	public ResponseObjectService findpostoffollowers(IdObject id) {
		ResponseObjectService resobj=new ResponseObjectService();
		List<String> followers=followersrepository.getfollowing(id.getId());
		if(followers.isEmpty()) {
			List<FeedPosts> postlist=new ArrayList<>();
			User usr=userdetailsreposiotory.getuserbyid(id.getId());
			List<Posts> usrpost = postsrepository.findpostbyid(id.getId());
			if(usrpost!=null) {
				for(Posts post:usrpost) {
					postlist.add(new FeedPosts(usr,post));
				}
			}
            if(postlist.isEmpty()) {
            	resobj.setStatus("fail");
    			resobj.setMessage("U dont have any followers to show the post and no post from your account");
    			resobj.setUserdetail(null);
    			return resobj;
            }
            else {
            	Collections.sort(postlist, (o1, o2) -> o2.getPosts().getDate().compareTo(o1.getPosts().getDate()));
                resobj.setStatus("success");
                resobj.setMessage("success");
                resobj.setUserdetail(postlist);
            	return resobj;
            }
		}
		else {
			List<FeedPosts> postlist=new ArrayList<>();
			for(String followingid:followers) {
				User followinguser=userdetailsreposiotory.getuserbyid(followingid);
				followinguser.setPassword("");
				List<Posts> followingpost = postsrepository.findpostbyid(followingid);
				if(followingpost!=null) {
					for(Posts post:followingpost) {
						postlist.add(new FeedPosts(followinguser,post));
					}
				}
			}
			User usr=userdetailsreposiotory.getuserbyid(id.getId());
			List<Posts> usrpost = postsrepository.findpostbyid(id.getId());
			if(usrpost!=null) {
				for(Posts post:usrpost) {
					postlist.add(new FeedPosts(usr,post));
				}
			}
            if(postlist!=null) {
            	Collections.sort(postlist, (o1, o2) -> o2.getPosts().getDate().compareTo(o1.getPosts().getDate()));
                resobj.setStatus("success");
                resobj.setMessage("success1");
                resobj.setUserdetail(postlist);
            	return resobj;
            }
            else {
            	resobj.setStatus("fail");
                resobj.setMessage(" Nobody posted from your following list and cannot find any post from user id: " + id.getId());
                resobj.setUserdetail(null);
                return resobj;
            }
		}
	}
}
