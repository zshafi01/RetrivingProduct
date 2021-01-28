package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simlilearning.workshop.Product;
import com.simlilearning.workshop.ProductDAO;

/**
 * Servlet implementation class SelectByIdProduct
 */
public class SelectByIdProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
//		Product p = new Product();
		int id= Integer.parseInt(request.getParameter("id"));
		
		ProductDAO pd= new 	ProductDAO();
		Product sp = pd.selectProduct(id);
		out.println("<html> <body>"
				+ "<table style=\"width:100%\">" + 
				"  <tr>" + 
				"    <th>Id</th>" + 
				"    <th>Product_Name</th>" + 
				"    <th>Price</th>" + 
				"    <th>Detail</th>" + 
				"  </tr>" + 
				"  <tr>" + 
				"    <td> "+sp.getId()+"</td>" + 
				"    <td>"+sp.getName()+" </td>" + 
				"    <td>"+sp.getPrice()+" </td>" + 
				"    <td>"+sp.getDetail()+" </td>" + 
				"  </tr>" + 
				
				"</table>"
				+ "</body></html>");
//		out.println(sp.getId());
//		out.println(sp.getName());
//		out.println(sp.getPrice());
//		out.println(sp.getDetail());
//		pd.selectProduct(1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
