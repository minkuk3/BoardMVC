package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.common.BoardDAO;

public class BoardCountService {

	public static int BoardCount(int btype){
		int result = 0;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.BoardCount(btype);
		System.out.println("result"+result);
		
		System.out.printf("btype : %d\n", btype);
		
		
		return result;	
	}
}
