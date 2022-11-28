<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read05 20221128</title>
</head>
<body>
	<h3>
		5) Model 객체를 통해 중첩된 자바빈즈 객체를 전달할 수 있다
	</h3>
	
	<h4>user.address :</h4>
	user.address.postCode : ${user.address.postCode }<br/>
	user.address.location : ${user.address.location }<br/>
	<hr/>
	
	<h4>user.cardList :</h4>
	<c:forEach items="${user.cardList }" var="card"> 
		<c:out value="${card.no } ${card.validMonth }"/>
	</c:forEach>
	<br/><br/>
	
	<c:forEach items="${user.cardList }" var="card"> 
		<c:out value="${card.no }"/> <br/>
		<c:out value="${card.validMonth }"/> <br/>
	</c:forEach>
	<br/>
	
	<c:forEach items="${user.cardList }" var="card"> 
		${card.no } ${card.validMonth } <br/>
	</c:forEach>
	
	
</body>
</html>