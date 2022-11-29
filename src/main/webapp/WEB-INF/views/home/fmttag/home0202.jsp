<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0202 20221129</title>
</head>
<body>
	<p>3) type 속성이 currency 입니다.</p>
	<p>coin : ${coin }</p>
	<!-- 
		￦ 포함되어 있는 문자열(숫자로 되어있는 문자열)은fmt:parseNumber 태그를 이용해서 변환이 가능한데
	 	이때, 변환될 타입 조건이 type 'currency'에 부합되는 ￦를 포함하는 문자열인 경우
	 -->
	<fmt:parseNumber value="${coin }"  type="currency" var="coinNum"/>
	<p>coinNum : ${coinNum }</p>
</body>
</html>