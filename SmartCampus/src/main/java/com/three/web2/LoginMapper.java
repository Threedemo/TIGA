package com.three.web2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.three.web2.pojo.Login;

@Mapper
public interface LoginMapper {

	@Insert("insert into login (loginName,loginPassword,enabled,authority)"
			+ "values(#{loginName},#{loginPassword},#{endbled},#{authority})")
	void save(Login login);
}
