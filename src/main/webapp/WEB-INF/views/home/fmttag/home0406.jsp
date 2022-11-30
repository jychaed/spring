<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0406 20221130</title>
</head>
<body>
	<p>15) pattern 속성을 지정하여 문자열을 Date객체로 변환한다</p>
	<p>dateValue : ${dateValue }</p>
	<p><fmt:parseDate value="${dateValue }" pattern="yyyy-MM-dd HH:mm:ss" var="date"/> </p>
	<p>date : ${date }</p>
	
</body>
</html>