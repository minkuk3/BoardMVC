<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">

	<input type="hidden" name="bid" value="${param.bid}"> <input
		type="hidden" name="btype" value="${param.btype}">
	<table>
		<c:forEach var="vo" items="${data}">
			<tr>
				<td>제목</td>
				<td>${vo.btitle}</td>
			</tr>
			<tr>
				<td>작성일시</td>
				<td>${vo.bregdate}</td>
			</tr>
			<tr>
				<td colspan="2">${vo.bcontent}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="목록"
		onclick="location.href='boardList.bo?btype=${param.btype}'"> <input
		type="button" value="수정"
		onclick="location.href='boardWrite.bo?btype=${param.btype}&bid=${param.bid}'">
	<input type="button" value="삭제"
		onclick="location.href='boardDelete.bo?btype=${param.btype}&bid=${param.bid}'">

	<form action="boardComment.bo?btype=${param.btype}&bid=${param.bid}"
		method="post">
		<textarea class="" name="t_comment"></textarea>
		<button type="submit">버튼</button>
	</form>


	<table>

		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>

		<c:forEach var="vo2" items="${commentData}">
			<tr>
				<td>${vo2.cid}</td>
				<td>${vo2.t_comment }</td>
				<td>${vo2.cregdate}</td>
			</tr>
		</c:forEach>
		
	</table>
</div>