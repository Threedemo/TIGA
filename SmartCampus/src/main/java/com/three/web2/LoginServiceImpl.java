package com.three.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.web2.pojo.Login;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public void save(Login login) {
		loginMapper.save(login);
	}

}
