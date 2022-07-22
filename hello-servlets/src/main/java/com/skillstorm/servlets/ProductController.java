package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.FakeProductDAO;
import com.skillstorm.models.Product;

//Controller for the MVC Product.Java
//Controller - glues the model to the view
//@WebServlet(urlPatterns = "/products")
public class ProductController extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
	private FakeProductDAO dao = new FakeProductDAO();
	
	// products?id=1 - GET (Doesn't do a body)
	// products?price=3&name=p
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("Dan", "Pickles");
		resp.addCookie(cookie);
		if(req.getSession().getAttribute("addedItem") != null) {
			System.out.println(req.getSession().getAttribute("addedItem"));
		}
		
		String param = req.getParameter("id"); //query parameter
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		resp.setContentType("application/json");
		if (param != null) {
			int id = Integer.parseInt(param);
			System.out.println(id);
			//add it to my JDBC query
			json = objectMapper.writeValueAsString(dao.findAll().get(id));
		}else {
			json = objectMapper.writeValueAsString(dao.findAll());
			// Content Negotiation
			// Content-Type
			// text/html	text/plain	application/xml	image/jpeg
		}
		resp.getWriter().println(json);	
		//resp.getWriter().print(new ObjectMapper().writeValueAsString(dao.findAll()));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getCookies() != null) {
			for (Cookie cookie :req.getCookies()) {
				if(cookie.getName().equals("Dan")) {
					System.out.println("Found Cookie! " + cookie.getValue());
				}
			}
		}
				
		//HTTP request body
		InputStream requestBody = req.getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		
		//take inputStream and convert it into a Product object
		//What json looks like { "id" : 1, "name": "Pickles", "price":3.50}
		Product product = objectMapper.readValue(requestBody, Product.class);
		dao.add(product);
		System.out.println("Added Product: "+ product);
		req.getSession().setAttribute("addedItem", product); //tracking products you added
		
		// 200 OK (By default)
		// 201 CREATED (POST is unsafe) (GET is safe) DELETE (is Unsafe)
		resp.setStatus(201);

		//This would have the same in one line
		//dao.add(new ObjectMapper().readValue(req.getInputStream(), Product.class));
	}
}
