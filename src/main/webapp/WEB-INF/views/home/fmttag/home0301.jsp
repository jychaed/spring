<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0301 20221130</title>
</head>
<body>
	<p>6) type 속성을 date로 지정하여 날짜 포맷팅을 한다</p>
	<p>now : ${now }</p>
	<p>date default :<fmt:formatDate value="${now }" type="date" dateStyle="default"/> </p>
	<p>date short :<fmt:formatDate value="${now }" type="date" dateStyle="short"/> </p>
	<p>date medium :<fmt:formatDate value="${now }" type="date" dateStyle="medium"/> </p>
	<p>date long :<fmt:formatDate value="${now }" type="date" dateStyle="long"/> </p>
	<p>date full :<fmt:formatDate value="${now }" type="date" dateStyle="full"/> </p>
	<!-- 
		dateStyle에 대한 출력 형태를 보고, 원하는 출력 패턴으로 설정하도록 합시다!
	 -->
</body>
</html>