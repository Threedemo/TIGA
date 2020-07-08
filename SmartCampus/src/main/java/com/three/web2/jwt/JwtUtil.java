package com.three.web2.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;



@Component
public class JwtUtil {
	
	//加密方式
	private static Algorithm algorithm = Algorithm.HMAC256("thefirsttoken123");
	//超时时间30分钟
	private static Date expiresDate = new Date(System.currentTimeMillis() + 30*60*1000);
	/**
	 * 生成带有用户名的token
	 * @param username
	 * @return
	 */
	public String creattoken(String loginName) {
		
		
		 Map<String, Object> header = new HashMap<>(2);
	        header.put("Type", "Jwt");
	        header.put("alg", "HS256");
	        return JWT.create()
	                .withHeader(header)
	                .withClaim("loginName", loginName)
	                .withExpiresAt(expiresDate)
	                .sign(algorithm);
	}
	
	public String gettoken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("thefirsttoken123");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String loginName = jwt.getClaim("loginName").asString();
            return loginName;
        } catch (Exception e){
            return "null";
        }
    }
}
