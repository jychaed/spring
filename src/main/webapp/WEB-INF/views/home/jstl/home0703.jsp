<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0703 20221129 </title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p> 객체를 요소값으로 가지는 List인 경우에 var 속성에 객체 변수를 지정하여 처리한다.</p>
	<c:forEach items="${member.cardList }" var="card" varStatus="stat">
		${stat.count } - ${card.no } : ${card.validMonth }<br/>
	</c:forEach>
	
</body>
</html>