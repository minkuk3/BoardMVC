package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.action.BoardVO;
import kr.itedu.boardmvc.action.CommentVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardDetailService {

	public ArrayList<BoardVO> getBoardDetail(int btype, int bid){
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardDetail(btype, bid);
		System.out.println("result"+result);
		
		System.out.printf("btype : %d\n", btype);
		
		for(BoardVO vo : result) {
			System.out.printf("bid : %d\n", vo.getBid());
			System.out.printf("btitle : %s\n", vo.getBtitle());
			System.out.printf("bcontent : %s\n", vo.getBcontent());
			System.out.printf("bregdate : %s\n", vo.getBregdate());
			System.out.println("------------------------");
		}
		
		return result;	
	}

	public ArrayList<CommentVO> getBoardComment(int btype, int bid) {
		ArrayList<CommentVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardComment(btype, bid);
		System.out.println("result"+result);
		
		System.out.printf("btype : %d\n", btype);
		
		for(CommentVO vo : result) {
			System.out.printf("cid : %d\n", vo.getCid());
			System.out.printf("bid : %s\n", vo.getBid());
			System.out.printf("btype : %s\n", vo.getBtype());
			System.out.printf("t_comment : %s\n", vo.getT_comment());
			System.out.printf("cregdate : %s\n", vo.getCregdate());
			System.out.println("------------------------");
		}
		
		return result;	
	}
	
}
