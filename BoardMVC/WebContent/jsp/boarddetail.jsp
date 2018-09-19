<%@page import="kr.itedu.boardmvc.action.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BoardVO> result = (ArrayList<BoardVO>)request.getAttribute("result");
	int bid = Integer.parseInt(request.getAttribute("bid").toString());
	String btype = (String)request.getAttribute("btype");  
%>
<div class="container">
	<input type="hidden" name="bid" value="<%=bid %>">
	<input type="hidden" name="btype" value="<%=btype %>">
	<table>
	<%for(BoardVO vo : result){ %>
		<tr>
			<td>제목</td>
			<td><%=vo.getBtitle() %></td>
		</tr>
		<tr>
			<td>작성일시</td>
			<td><%=vo.getBregdate() %></td>
		</tr>
		<tr>
			<td colspan="2"><%=vo.getBcontent() %></td>
		</tr>
	<%} %>
	</table>
	<input type="button" value="목록" onclick="location.href='boardList?btype=<%= btype%>'">
	<input type="button" value="수정" onclick="location.href='boardwrite?btype=<%=btype %>&bid=<%=bid %>'">
	<input type="button" value="삭제" onclick="location.href='boarddelete?btype=<%=btype %>&bid=<%=bid %>'">
</div>