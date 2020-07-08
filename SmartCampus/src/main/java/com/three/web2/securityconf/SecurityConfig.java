package com.three.web2.securityconf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//网络安全适配器
@EnableWebSecurity//启用web安全
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${spring.datasource.url}")
	String url;

	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String pwd;
//	
//	@Value("com.mysql.cj.jdbc.Driver")
//	String driver;

	@Bean
	public DataSource getDS() {
		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(pwd)
				.build();
	}
	//授权
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.csrf().disable()
        .formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/logincheck")
        .defaultSuccessUrl("/").successHandler(new LoginSuccessHandle())
        .and()
        .authorizeRequests()
        .antMatchers("/login.html","index.html","/"
        		,"/admin/notice","/admin/notice/*","student/js/*").permitAll()
        .antMatchers("/student","/student/*").hasRole("STUDENT")
        .antMatchers("/teacher","/teacher/*").hasRole("TEACHER")
        .antMatchers("/admin","/admin/*").hasRole("ADMIN")
        .anyRequest()
        .authenticated();
	}
	
	//认证	1.基于内存 2.基于数据库
	//基于内存
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(auth);
//		//基于内存
//		auth.inMemoryAuthentication()
//			.passwordEncoder(new BCryptPasswordEncoder())//密码编辑器
//			.withUser("bob").password(new BCryptPasswordEncoder().encode("111")).roles("stu").and()
//			.withUser("rose").password(new BCryptPasswordEncoder().encode("222")).roles("stu");
		//基于数据库
		auth.jdbcAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			.dataSource(getDS())
			.usersByUsernameQuery("select loginName,loginPassword,enabled from login where loginName = ?")//查询用户
			
			.authoritiesByUsernameQuery("select loginName,authority from login where loginName = ?");//查询用户权限
			
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//记载静态资源
		web.ignoring().antMatchers("/**/*.js", "/lang/*.json", "/**/*.css", "/**/*.js", "/**/*.map",
	            "/**/*.png");
	}
}
