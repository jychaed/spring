<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0701 20221129 </title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p> List에 저장되어 잇는 값을 순차적으로 처리한다.</p>
	<c:forEach items="${member.hobbyList }" var="hobby" varStatus="stat">
		${stat.count } - ${hobby }<br/>
	</c:forEach>
	
</body>
</html>