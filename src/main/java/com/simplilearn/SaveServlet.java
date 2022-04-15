package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
PrintWriter out= response.getWriter();
		
		//connection pool
		SessionFactory factory= HibernateUtil.getSessionFactory();
		
		// connection
		
		Session session= factory.openSession();
		response.setContentType("text/html");
		
		Transaction tx=session.beginTransaction();
		String s=request.getParameter("pname");
		String s1=request.getParameter("model");
		String s2=request.getParameter("price");
		int n=Integer.parseInt(request.getParameter("stock"));
		Product pro= new Product();
	    pro.setProductname(s);
		pro.setModel(s1);
		pro.setPrice(s2);
		pro.setStockleft(n);
		
		session.save(pro);
		
		tx.commit();
		session.close();
		out.print("<title>saved</title>");
		
		response.getWriter().print("Data Inserted Successfully");
		out.print("<br><form action='display' > <input type='submit' value='display data'></form>");
		
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}