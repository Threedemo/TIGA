package com.three.web2.pojo;
/**
 * 
 * 统一认证表
 */
public class Login {
	
	
	int lid;
	
	//账号
	String loginName;
	
	//密码
	String loginPassword;
	
	//用户状态
	int endbled;
	
	//用户角色
	String authority;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public int getEndbled() {
		return endbled;
	}

	public void setEndbled(int endbled) {
		this.endbled = endbled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Login [lid=" + lid + ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", endbled="
				+ endbled + ", authority=" + authority + "]";
	}
	
	
}
