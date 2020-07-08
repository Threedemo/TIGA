package com.three.web2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.three.web2.pojo.Login;

@Mapper
public interface LoginMapper {

	@Insert("insert into login (loginName,loginPassword,enabled,authority)"
			+ "values(#{loginName},#{loginPassword},#{endbled},#{authority})")
	void save(Login login);
	
	/**
	 * 匹配账号
	 * @param ln
	 * @return
	 */
	@Select("select * from `login` where loginName=#{ln}")
	Login getOne(String ln);
	
	/**
	 * 修改密码
	 * @param ln
	 * @param lp
	 * @return
	 */
	@Update("update `login` set loginPassword=#{lp} where loginName=#{ln}")
	void upl(String ln,String lp);
	
	@Update("update login set endbled=0 where id=#{loginName} ")
	void update(String loginName);
}
