package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.service.boardDeleteService;
import kr.itedu.boardmvc.service.writeSubmitService;

public class boardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		// DB를 가져오는 문장 거시기
		boardDeleteService service = new boardDeleteService();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));

		service.BoardDelete(bid, btype);
		forward.setPath("boardList.bo?btype=" + btype);
		forward.setRedirect(true);

		return forward;
	}

}
