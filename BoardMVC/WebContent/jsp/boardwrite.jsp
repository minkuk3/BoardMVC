<%@page import="kr.itedu.boardmvc.action.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String btype = (String)request.getAttribute("btype");
	int bid = Integer.parseInt(request.getAttribute("bid").toString());
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("result");
%>
<form action="boardwrite?btype=<%=btype %>&bid=<%=bid %>" method="post">
	<table>
	<%if(bid!=0){ %>
		<%for(BoardVO vo : result){ %>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" value="<%=vo.getBtitle() %>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="8" cols="100" name="bcontent"><%=vo.getBcontent() %></textarea>
				</td>
			</tr>
	<%	}
	}else{%>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="8" cols="100" name="bcontent"></textarea>
				</td>
			</tr>
	<%} %>
	</table>
	<input type="submit" value="전송">
</form>