package kr.itedu.boardmvc;

public class ActionForward {
	
	private String path;
	private boolean isRedirect;
	
	// 575p 참고
	// 응답해줄 페이지에 url 주소값과 포워딩방식? 어떤 방식으로 응답해줄건지
	// 디스패치는 URl 변경없이 그대로 전송 리퀘스트 영역을 공유한다
	// 리다이렉트는 URl변경이 되는데 요청도 바뀌고 리퀘스트 영역에 접근 못함
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
