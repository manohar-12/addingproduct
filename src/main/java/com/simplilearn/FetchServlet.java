package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

 

 
@WebServlet("/display")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//connection pool
		SessionFactory factory= HibernateUtil.getSessionFactory();
		
		// connection
		response.setContentType("text/html");
		
		Session session= factory.openSession();
		
		List<Product> list =session.createQuery("from Product").list();// Student is name of class not a name of table
		
		PrintWriter out= response.getWriter();
		out.print("<title>display data</title>");
		
		for (Product c :list) {
			out.println("Id: 	"+c.getId()+"	 "+"ProductName:    "+c.getProductname()+" 		  "+" Model:     "+c.getModel()+" 		"+" Price:	"+c.getPrice()+" 	"+" stockleft:     "+c.getStockleft());
		out.print("<br>");
		}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}