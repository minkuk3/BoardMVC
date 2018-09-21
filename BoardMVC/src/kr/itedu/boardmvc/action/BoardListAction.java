package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardCountService;
import kr.itedu.boardmvc.service.BoardGetPaging;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ActionForward 리턴을 해야해서
		// 1. ActionForward 객체화를 먼저해야한다

		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		

		// DB를 가져오는 문장 거시기
		
		BoardGetPaging service = new BoardGetPaging();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int page = Utils.getParamInt2(request.getParameter("page"));
	
		
		ArrayList<BoardVO> data = service.getPaging(btype, page);
		
		

		int count = BoardCountService.BoardCount(btype);

		// 템플릿 쓸것
		request.setAttribute("title", Var.TITLES[btype]); // 헤더 부분 제목
		request.setAttribute("content", "boardList"); // 콘텐츠 jsp파일명
		request.setAttribute("cssName", "boardlist"); // css 이름
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("data_size", data.size()); // 리스트 사이즈 확인 오류잡는것
		request.setAttribute("count", (count / 10) + 1);
		System.out.println(count);

		// request.setAttribute("boardList", result);
		/*
		 * Connection con = DBConnector.getConn(); System.out.println( "확인 : "+ con);
		 */

		return forward;
	}

}
