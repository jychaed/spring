<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read06 20221128</title>
</head>
<body>
	<h3>
		6) Model 객체를 통해 다양한 타입의 값을 전달할 수 있다.
	</h3>
	

	user.userId : ${user.userId }<br/>
	user.password : ${user.password }<br/>
	user.userName : ${user.userName }<br/>
	user.email : ${user.email }<br/>
	user.birthDay : ${user.birthDay }<br/>
	user.gender : ${user.gender }<br/>
	user.hobby : ${user.hobby }<br/>
	
	<c:forEach items="${user.hobbyArray }" var="hobby"> 
		<c:out value="${hobby }"/> <br/>
	</c:forEach>
	<br/>
	
	<c:forEach items="${user.hobbyList }" var="hobby"> 
		<c:out value="${hobby }"/> <br/>
	</c:forEach>
	<br/>
	
	user.foreigner : ${user.foreigner }<br/>
	user.developer : ${user.developer }<br/>
	user.nationality : ${user.nationality }<br/>
	user.address.postCode : ${user.address.postCode }<br/>
	user.address.location : ${user.address.location }<br/>
	
	<c:forEach items="${user.cardList }" var="card"> 
		<c:out value="${card.no } ${card.validMonth }"/> <br/>
	</c:forEach>
	<br/>
	
	<c:forEach items="${user.cardList }" var="card"> 
		<c:out value="${card.no }"/> <br/>
		<c:out value="${card.validMonth }"/> <br/>
	</c:forEach>
	<br/>
	
	<c:forEach items="${user.cardList }" var="card"> 
		${card.no } ${card.validMonth } <br/>
	</c:forEach>
	<br/>
	
	user.cars : ${user.cars } <br/>
	
	<c:forEach items="${user.carArray }" var="car"> 
		${car } <br/>
	</c:forEach>
	<br/>
	
	<c:forEach items="${user.carList }" var="car"> 
		${car } <br/>
	</c:forEach>
	<br/>
	
	user.introduction : ${user.introduction }<br/>
	user.dateOfBirth : ${user.dateOfBirth }<br/>
	
</body>
</html>













