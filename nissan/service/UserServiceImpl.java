package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repo.IUserRepository;
import com.nissan.util.JwtUtil;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String Password) {
		// verify user exist or not
		User user=userRepository.findUserByNameAndPassword(userName, Password);
		if(user==null) {
			apiResponse.setData("Invalid Credentials");
			return apiResponse;
		}
		//credentials are correct then
		String token=jwtUtil.generateJwt(user);
		
		//storing more details and token
		Map<String,Object>data = new HashMap<String,Object>();
		data.put("ACCESSTOKEN",token);
		data.put("role",user.getRoleId());
		data.put("UserName",user.getUserName());
		
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		
		return apiResponse;
	}

}

