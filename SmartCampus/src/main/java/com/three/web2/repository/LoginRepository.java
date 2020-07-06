package com.three.web2.repository;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Login;

/**
 * 登录仓库
 * @author win10
 *
 */

@Repository
public interface LoginRepository {
	
	/**
	 * 修改密码
	 * 
	 * @param lp
	 * @param ln
	 * @return
	 */
	@Update("update `login` set loginPassword=#{lp} where loginName=#{ln}")
	Login upl(String lp, String ln);

}
