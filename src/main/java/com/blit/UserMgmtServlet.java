package com.blit;

import java.io.IOException;

import com.blit.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.blit.doa.UserMgmtDOAImp;
import com.blit.doa.UserMgmtDOA;

public class UserMgmtServlet extends HttpServlet {
	
	private UserMgmtDOA userDao = new UserMgmtDOAImp();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setStatus(404);
		String URI = req.getRequestURI();
		
		System.out.println("registering user");

		
		User user = new User();
		user.setId(1);
		user.setUserName("Sajia");
		user.setPassword("swre43");
		user.setEmail("sajia.@gmail.com");
		
		
		userDao.registerUser(user);
		 
		System.out.println("user " + user + " registered");

		

		// this will be "/MyLittlePetShop4/app/users/whatever"
		System.out.println(URI);

		// this will be ["","MyLittlePetShop4","app","users","whatever"]
		String[] uriSections = URI.split("/");
		if (uriSections.length >= 4) {
			System.out.println(uriSections[3]);

			

			}
		}
	}


	

	
	


