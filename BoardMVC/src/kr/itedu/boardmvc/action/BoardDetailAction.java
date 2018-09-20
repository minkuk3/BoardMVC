package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardDetailService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		// DB를 가져오는 문장 거시기
		BoardDetailService service = new BoardDetailService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid =Integer.parseInt( request.getParameter("bid"));
		
		ArrayList<BoardVO> data = service.getBoardDetail(btype, bid);

		// 템플릿 쓸것
		request.setAttribute("title", Var.TITLES[btype]+" 글보기" ); // 헤더 부분 제목
		request.setAttribute("content", "boardDetail"); // 콘텐츠 jsp파일명
		request.setAttribute("cssName", "boarddetail"); // css 이름
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("data_size", data.size()); // 리스트 사이즈 확인 오류잡는것
		
		return forward;
	}

}
