package com.miniproject.registration.util;

import java.util.regex.*;

public class UserUtil {
	public static boolean validateEmail(String email) {
		String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public static boolean validateName(String name) {
		String pattern = "^[A-Za-z ]\\w{3,50}$";
		Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);
        return m.matches();
	}
}
