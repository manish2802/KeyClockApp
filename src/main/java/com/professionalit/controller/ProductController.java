package com.professionalit.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/public")
	public String publicApi() {

		return "Public API";

	}

	@GetMapping("/user/products")
	public String products(@AuthenticationPrincipal Jwt jwt) {
		return "Hello "
				+ jwt.getClaimAsString("preferred_username");
	}

	@GetMapping("/admin/dashboard")
	public String dashboard() {

		return "Admin Dashboard";
	}
}