package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.boardmvc.action.BoardVO;

//Query문
public class BoardDAO {

	private static BoardDAO dao;

	private BoardDAO() {
	} // private생성자

	public static BoardDAO getInstance() { // 싱글톤 에서는 멤버필드를 쓰지 않는게 좋다
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String query = String.format(" SELECT BID, BTITLE, BCONTENT, "+
			" to_char(bregdate, 'YYYY-MM-DD hh24:mi') as bregdate "+
			" from t_board%d ORDER BY BID DESC ", btype);
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");
				
				BoardVO model = new BoardVO();
				model.setBid(bid);
				model.setBtitle(btitle);
				model.setBcontent(bcontent);
				model.setBregdate(bregdate);
				
				result.add(model);
			}
			

		} catch (SQLException e) {
			// TODO: 예외처리
			System.out.println("fuck");
			e.printStackTrace();

		}  catch (Exception e) {
			// TODO: Exception 마지막으로 에러 잡는 곳
			e.printStackTrace();

		}finally {
			close(con, null, null);
		}

		return result;
	}

	private PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
