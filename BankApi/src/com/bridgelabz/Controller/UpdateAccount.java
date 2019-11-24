package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bridgelabz.BankDAO.BankDAO;

//@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String accountId = req.getParameter("id");
		System.out.println("accountId----> "+accountId);
		int pid = Integer.parseInt(accountId);
		JSONObject obj=BankDAO.updateAccount(pid);
		out.print(obj.toJSONString());
		System.out.println("------>"+obj.get("name"));
		BankDAO.editAccount(pid);
		
	}
}
