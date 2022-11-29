<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0203 20221129</title>
</head>
<body>
	<p>5) pattern 속성을 사용하여 직접 사용할 서식을 지정한다</p>
	<p>coin : ${coin }</p>
	<fmt:parseNumber value="${coin }"  pattern="0,000.00" var="coinNum"/>
	<!-- 이부분 안먹어서 선생님이 확인해보시기로함! -->
	<p>coinNum : ${coinNum }</p>
</body>
</html>