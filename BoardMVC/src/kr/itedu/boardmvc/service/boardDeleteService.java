package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.common.BoardDAO;

public class boardDeleteService {

public void BoardDelete(int bid, int btype) {
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.BoardDelete(bid, btype);

	}
}
