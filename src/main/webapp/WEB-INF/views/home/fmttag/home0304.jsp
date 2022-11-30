<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0304 20221130</title>
</head>
<body>
	<p> 9) pattern 속성을 지정하여 날짜를 포맷팅한다</p>
	<p>now : ${now }</p>
	<p>pattern :<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /> </p>
	<p>pattern :<fmt:formatDate value="${now }" pattern="a h:mm" /> </p>
	<p>pattern :<fmt:formatDate value="${now }" pattern="z a h:mm" /> </p>
	
</body>
</html>