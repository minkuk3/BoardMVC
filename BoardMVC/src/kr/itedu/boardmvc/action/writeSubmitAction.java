package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.writeSubmitService;

public class writeSubmitAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		
		// DB를 가져오는 문장 거시기
		writeSubmitService service = new writeSubmitService();
		int bid = Integer.parseInt(request.getParameter("bid"));		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardVO vo = new BoardVO();
		vo.setBid(bid);
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setBtype(btype);
		
		if(bid > 0) {
			service.BoardUpdate(vo);
			forward.setPath("boardDetail.bo?btype="+btype+"&bid="+bid);
		}else {
			service.BoardInsert(vo);
			forward.setPath("boardList.bo?btype="+btype);
		}
		
		forward.setRedirect(true);
		
		return forward;
	}

}
