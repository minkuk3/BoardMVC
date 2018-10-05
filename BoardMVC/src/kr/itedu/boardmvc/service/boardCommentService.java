package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.common.BoardDAO;

public class boardCommentService {
	public void BoardComment(int bid, int btype, String t_comment) {

		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardComment(bid, btype, t_comment);

	}

}
