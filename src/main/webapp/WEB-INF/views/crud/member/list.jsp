<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<h3>LIST</h3>
	<a href="/crud/member/register">등록</a>
	<table border="1">
		<tr>
			<th align="center" width="60">번호</th>
			<th align="center" width="80">아이디</th>
			<th align="center" width="80">비밀번호</th>
			<th align="center" width="80">사용자명</th>
			<th align="center" width="100">작성일</th>
		</tr>	
		<c:forEach items="${list }" var="member">
			<tr>
				<td align="center" >${member.userNo }</td>
				<td align="center" ><a href="/crud/member/read?userNo=${member.userNo }">${member.userId }</a></td>
				<td align="center" >${member.userPw }</td>
				<td align="center" >${member.userName }</td>
				<td align="center" ><fmt:formatDate value="${member.regDate }" pattern="yyyy-MM-dd HH:mm"/> </td>
			</tr>	
		</c:forEach>
	</table>
	
</body>
</html>