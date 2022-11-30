<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0302 20221130</title>
</head>
<body>
	<p>7) type 속성을 time으로 지정하여 시간 포맷팅을 한다</p>
	<p>now : ${now }</p>
	<p>time :<fmt:formatDate value="${now }" type="time" /> </p>
	<p>time default:<fmt:formatDate value="${now }" type="time" dateStyle="default"/> </p>
	<p>time short:<fmt:formatDate value="${now }" type="time" dateStyle="short"/> </p>
	<p>time medium:<fmt:formatDate value="${now }" type="time" dateStyle="medium"/> </p>
	<p>time long:<fmt:formatDate value="${now }" type="time" dateStyle="long"/> </p>
	<p>time full:<fmt:formatDate value="${now }" type="time" dateStyle="full"/> </p>
	
</body>
</html>