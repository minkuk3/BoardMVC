package kr.itedu.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;

public interface Action {
	// 리턴 타입 은액션포워드

	//인터페이스 만들면 지시자 기본적으로 퍼블릭 들어간다.
	//퍼블릭이 왜 들어가야하나? 구현 사용을 해야해서 /앱섹트 추상 그다음 컨트롤러 만든다
	ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
