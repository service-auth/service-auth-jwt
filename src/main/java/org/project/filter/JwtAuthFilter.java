package org.project.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {
     private AuthenticationManager manager;
     
     public JwtAuthFilter(AuthenticationManager manager) {
    	
       this.manager = manager;
       System.out.println(this.manager.toString());
     }
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		return manager.authenticate(authenticationToken);
	
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("succeful authentication---");
		User user = (User) authResult.getPrincipal();
		System.out.println(user.toString());
		/*Algorithm algorithm = Algorithm.HMAC256("mysecrt1234");
		String jwtAccesToken = JWT.create()
				.withSubject(user.getName())
				.withExpiresAt(new Date(System.currentTimeMillis() + 5*60*1000))
				.withIssuer(request.getRequestURI().toString())
				.sign(algorithm);*/
		//response.setHeader("Authorization", jwtAccesToken);
		
	}
	
	
}
