<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>    
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Free Board List</title>
</head>
<body>
	<h2>Free Board List</h2>
	<a href="/crud/free/register">등록</a>
	<table border="1">
		<tr>
			<td align="center" width="80">번호</td>
			<td align="center" width="320">제목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="180">작성일</td>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4">조회하실 게시물이 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="board">
					<tr>
						<td align="center">${board.boardNo }</td>
						<td align="left"><a href="/crud/free/read?boardNo=${board.boardNo }">${board.title }</a></td>
						<td align="right">${board.writer }</td>
						<td align="center"><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd hh:mm"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>