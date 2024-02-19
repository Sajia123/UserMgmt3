package com.blit;

import java.io.IOException;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserMgmtServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setStatus(404);
		String URI = req.getRequestURI();

		// this will be "/MyLittlePetShop4/app/users/whatever"
		System.out.println(URI);

		// this will be ["","MyLittlePetShop4","app","users","whatever"]
		String[] uriSections = URI.split("/");
		if (uriSections.length >= 4) {
			System.out.println(uriSections[3]);

			

			}
		}
	}


	

	
	


