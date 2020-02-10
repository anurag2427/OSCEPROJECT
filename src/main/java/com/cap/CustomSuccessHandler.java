package com.cap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component

public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		//System.err.println("ROLE:::::::::check");

		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/*
	 * This method extracts the roles of currently logged-in user and returns
	 * appropriate URL according to his/her role.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		String url = "";
		System.err.println("in dtu");

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<>();

		for (GrantedAuthority a : authorities) {
			System.err.println("Auth:"+a.getAuthority());
			roles.add(a.getAuthority());
		}

		if (isAdmin(roles)) {
		

			url = "/adminPage";
		} 
		
		else if (isUser(roles)) {
		

			url = "/userPage";
		}
		
		else if (isSeller(roles)) {
			

			url = "/sellerPage";
		}

		return url;
	}

	private boolean isUser(List<String> roles) {
		
		return roles.contains("USER");
		
		
	}
	
	private boolean isSeller(List<String> roles) {
		
		return roles.contains("SELLER");
		
		
	}

	private boolean isAdmin(List<String> roles) {
		
		return roles.contains("ADMIN");
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
