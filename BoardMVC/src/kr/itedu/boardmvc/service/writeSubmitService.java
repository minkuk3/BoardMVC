package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.action.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class writeSubmitService {

	public void BoardInsert(BoardVO vo) {
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardInsert(vo);

	}
	
	public void BoardUpdate(BoardVO vo) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardUpdate(vo);
	}

}
