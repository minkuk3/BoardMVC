<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="writeSubmit.bo?btype=${btype}&bid=${param.bid}"
	method="post">
	<table>
		<c:choose>
			<%-- 
	<%if(bid!=0){ %>
		<%for(BoardVO vo : result){ %> --%>
			<c:when test="${param.bid != 0}">
				<c:forEach var="vo" items="${data}">
					<tr>
						<td>제목</td>
						<td><input type="text" name="btitle"
							value="${vo.btitle}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="8" cols="100" name="bcontent">${vo.bcontent}</textarea>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<%-- <%	}
	}else{%>  --%>
			<c:otherwise>
				<tr>
					<td>제목</td>
					<td><input type="text" name="btitle"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="8" cols="100" name="bcontent"></textarea></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<%-- <%} %> --%>
	</table>
	<input type="submit" value="전송">
</form>