package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.service.boardCommentService;
import kr.itedu.boardmvc.service.boardDeleteService;

public class boardCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();

		// DB를 가져오는 문장 거시기
		boardCommentService service = new boardCommentService();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		String t_comment = request.getParameter("t_comment");

		service.BoardComment(bid, btype, t_comment);
		forward.setPath("boardDetail.bo?btype=" + btype +"&bid=" + bid);
		forward.setRedirect(true);

		return forward;
	}

}
