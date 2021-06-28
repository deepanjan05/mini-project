package com.miniproject.webapp.services;

import javax.servlet.http.*;

import com.miniproject.authentication.entity.User;

import lombok.extern.slf4j.Slf4j;

public class AuthenticationService {
	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession session = req.getSession();

		if (session.getAttribute("userId")!=null) {
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie1 : cookies) {
				if (cookie1.getName().equals("userId") && session.getAttribute("userId").equals(cookie1.getValue())) {
					return true;
				}
			}
		}
		return false;
	}
}
