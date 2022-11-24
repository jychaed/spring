<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myBox.jsp</title>
</head>
<body>
	<h2>내 파일들</h2>
	<c:choose>
		<c:when test="${empty filenames }">
			<p>조회하실 파일이 존재하지 않습니다.</p>
		</c:when>
		<c:otherwise>
				<p>- mybox</p>
			<c:forEach items="${filenames }" var="filenames">
				&nbsp;	&nbsp;	&nbsp;	&nbsp;-${filenames }<br/>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>