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

/**
 * 게시글 작성 첨부파일 없는 버전
 */
@WebServlet("/board/write2")
public class BoardWriteServletForSimple extends MyHttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService service = new BoardService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Member loginMember = getSessionMember(req);
			if(loginMember != null) {
				req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
			}
		} catch (Exception e) {}
		sendCommonPage("로그인 이후 사용할수 있습니다.", "/", req, resp);
	}

	// 1. 사용자의 파라메터를 읽어온다. (가끔 없을수도 있다.)
	// 2. 사용자의 파라메터를 기준으로 필요시 DB CRUD 한다.
	// 3. DB 결과에 따라 페이지를 정하여 보내준다. // 실패시 -> 실패 결과 보이게끔, 성공 -> list 이동하게끔 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Member loginMember = getSessionMember(req);
			
			// 세션이 풀렸거나 실제 글쓴 사람과 세션이 일치하지 않는 경우 = 보안적인 요구사항
			if(loginMember == null
					|| loginMember.getId().equals(req.getParameter("writer")) == false) {
				sendCommonPage("잘못된 접근입니다. (code=101)", "/board/list", req, resp);
				return;
			}
			
			Board board = new Board();
			board.setTitle(req.getParameter("title").trim());
			board.setWriterId(req.getParameter("writer").trim());
			board.setWriterNo(loginMember.getNo());
			board.setContent(req.getParameter("content").trim());
			System.out.println(board);
			
			int result = service.save(board); // DB에 게시글 저장
			
			if(result > 0) {
				sendCommonPage("게시글이 정상적으로 등록되었습니다.", "/board/list", req, resp);
			}else {
				sendCommonPage("게시글 등록에 실패하였습니다. (code=102)", "/board/list", req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendCommonPage("정상적으로 처리할수 없습니다. (code=103)", "/board/list", req, resp);
	}
}










