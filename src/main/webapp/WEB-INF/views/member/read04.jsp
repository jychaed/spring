<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read04 20221128</title>
</head>
<body>
	<h3>
		4) Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다
	</h3>
	
	<p>Result</p>
	
	<h4>hobbyArray : </h4>
	<c:forEach items="${hobbyArray }" var="hobby"> 
		<c:out value="${hobby }"/>
	</c:forEach>
	
	<h4>hobbyList : </h4>
	<c:forEach items="${hobbyList }" var="hobby"> 
		<c:out value="${hobby }"/>
	</c:forEach>
	
	<h4>carArray : </h4>
	<c:forEach items="${carArray }" var="car"> 
		<c:out value="${car }"/>
	</c:forEach>
	
	<h4>carList : </h4>
	<c:forEach items="${carList }" var="car"> 
		<c:out value="${car }"/>
	</c:forEach>
	
</body>
</html>