package com.three.web2.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TeacherTest {
public static void main(String[] args) {
	String password="1234";
	
	password=new BCryptPasswordEncoder().encode(password);
	System.out.println(password);
	
	boolean falg=new BCryptPasswordEncoder().matches("1234", password);
	
	System.out.println(falg);
}
}
