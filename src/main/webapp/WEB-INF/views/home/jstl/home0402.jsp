<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0402 20221129</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>JSP 표현식에서 발생한 예외는 catch 변수 'ex'에 저장된다.</p>
	<%
		String[] hobbyArray = {"Music", "Movie"};
	%>
	
	<c:catch var="ex">
		<%= hobbyArray[3] %>
	</c:catch>
	<p>
		<c:if test="${ex != null }">
			${ex }
		</c:if>
	</p>
	
</body>
</html>