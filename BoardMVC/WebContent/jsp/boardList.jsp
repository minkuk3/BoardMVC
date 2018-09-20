<%@page import="kr.itedu.boardmvc.action.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="listdiv">
	<input type="hidden" name="btype" value="${btype}">
	<c:choose>
		<c:when test="${data_size != 0}">

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th width="800px">제목</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${data}">
						<tr>
							<td>${vo.bid }</td>
							<td><a href="boardDetail.bo?btype=${btype}&bid=${vo.bid } ">
									${vo.btitle }</a></td>
							<td>${vo.bregdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div>
			 내용
			</div>
		</c:when>
		<c:otherwise>
			게시글이 없습니다.
		</c:otherwise>
	</c:choose>
	<div class="listInput">
	<input type="submit" value="글쓰기" onclick="location.href='boardWrite.bo?btype=${btype}&bid=0'">
	</div>
</div>