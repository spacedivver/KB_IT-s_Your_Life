package com.multi.mvc.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.common.util.MyHttpServlet;
import com.multi.mvc.board.model.service.BoardService;
import com.multi.mvc.board.model.vo.Board;
import com.multi.mvc.member.model.vo.Member;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService service = new BoardService();
	
	
	//http://localhost/06_HelloMVC2/board/delete?boardNo=71
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			Board board = service.findBoardByNo(boardNo, false);
			Member loginMember = getSessionMember(req);
			
			// 권한확인 코드, 프로젝트에서는 없어도 된다.
			if(loginMember.getRole().equals("ROLE_ADMIN") == false
				&& loginMember.getId().equals(board.getWriterId()) == false){
				sendCommonPage("잘못된 권한입니다. (301)", "/board/list", req, resp);
				return;
			}
			
			int result = service.delete(boardNo);
			
			if(result <= 0) {
				sendCommonPage("게시물 삭제에 실패하였습니다. (302)", "/board/list", req, resp);
				return;
			}
			
			// 파일삭제
			deleteFile(board.getRenamedFilename());
			sendCommonPage("게시물 삭제에 성공하였습니다.", "/board/list", req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			sendCommonPage("게시물 삭제에 실패하였습니다. (303)", "/board/list", req, resp);
		}
	}

	

}
