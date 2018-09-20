package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardDetailService;
import kr.itedu.boardmvc.service.BoardWriteService;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);


		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		if(bid > 0) {
			// DB를 가져오는 문장 거시기
			BoardWriteService service = new BoardWriteService();
			ArrayList<BoardVO> data = service.getBoardDetail(btype, bid);
			
			request.setAttribute("title", Var.TITLES[btype]+" 글수정" ); // 헤더 부분 제목
			
			request.setAttribute("data", data);
			request.setAttribute("data_size", data.size()); // 리스트 사이즈 확인 오류잡는것
		}else{
			// 템플릿 쓸것
			request.setAttribute("title", Var.TITLES[btype]+" 글쓰기" ); // 헤더 부분 제목
			
		}
		request.setAttribute("content", "boardWrite"); // 콘텐츠 jsp파일명
		request.setAttribute("cssName", "boardwrite"); // css 이름
		request.setAttribute("btype", btype);
		
		return forward;
	}

}
