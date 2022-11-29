<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0501 20221129</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>test 속성에 true나 false를 리턴하는 조건문이 온다.</p>
	<c:if test="${member.hobbyArray == null }">
		<p>member.hobbyArray == null</p>
	</c:if>
	
	<c:if test="${member.hobbyArray eq null }">
		<p>member.hobbyArray eq null</p>
	</c:if>
	
	
	
</body>
</html>