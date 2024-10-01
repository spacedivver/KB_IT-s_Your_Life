package com.multi.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.mvc.member.model.service.MemberService;

@WebServlet("/member/checkId2")
public class MemberCheckIdServletForAJAX extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private MemberService service = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		boolean isDuplicated = service.isDuplicated(userId);
		System.out.println("중복 확인 : " + isDuplicated);
		
		if(isDuplicated == true) { // 사용중
			resp.getWriter().append("used");
		}else { // 미사용
			resp.getWriter().append("unused");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
