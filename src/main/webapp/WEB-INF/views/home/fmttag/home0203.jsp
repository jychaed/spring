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
	<p>3) type 속성이 percent 입니다.</p>
	<p>coin : ${coin }</p>
	<fmt:parseNumber value="${coin }"  type="percent" var="coinNum"/>
	<p>coinNum : ${coinNum }</p>
</body>
</html>