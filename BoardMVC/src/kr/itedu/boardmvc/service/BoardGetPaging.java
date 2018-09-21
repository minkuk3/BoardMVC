package kr.itedu.boardmvc.service;

import java.util.ArrayList;
import kr.itedu.boardmvc.action.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardGetPaging {

	public ArrayList<BoardVO> getPaging(int btype, int page){
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getPaging(btype, page);
		System.out.println("result"+result);
		
		return result;	
	}
}
