package kr.itedu.boardmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.action.Action;
import kr.itedu.boardmvc.action.BoardDetailAction;
import kr.itedu.boardmvc.action.BoardListAction;
import kr.itedu.boardmvc.action.BoardWriteAction;
import kr.itedu.boardmvc.action.boardDeleteAction;
import kr.itedu.boardmvc.action.writeSubmitAction;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // ServletException, IOException오류 던지기
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI(); // 전체 주소 가져오는곳
		System.out.println("reqURI: " + reqURI);

		String ctxPath = request.getContextPath(); // 인터넷 주소 중 루트 주소값 없에고 뒷 주소만 나오게
		System.out.println("ctxPath: " + ctxPath);

		String comd = reqURI.substring(ctxPath.length());
		ActionForward forward = null;
		Action action = null;

		// else if가 많아 질것이다!!
		// 보더 주소값 .bo
		if (comd.equals("/boardList.bo")) {
			action = (Action) new BoardListAction();
			try {
				forward = action.execute(request, response); // 어디로 갈것인가?
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}

		} else if (comd.equals("/boardDetail.bo")) {
			action = (Action) new BoardDetailAction();
			try {
				forward = action.execute(request, response); // 어디로 갈것인가?
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardWrite.bo")) {
			action = (Action) new BoardWriteAction();
			try {
				forward = action.execute(request, response); // 어디로 갈것인가?
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/writeSubmit.bo")) {
			action = (Action) new writeSubmitAction();
			try {
				forward = action.execute(request, response); // 어디로 갈것인가?
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		} else if (comd.equals("/boardDelete.bo")) {
			action = (Action) new boardDeleteAction();
			try {
				forward = action.execute(request, response); // 어디로 갈것인가?
			} catch (Exception e) {
				// TODO: 예외처리
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		} else {
			// TODO 없는 주소값 에러페이지 디스플레이 처리
		}
		// 오늘은 여기 까지!~~
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProc(request, response);
	}

}
