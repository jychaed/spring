<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fmttag Home0101 20221129</title>
</head>
<body>
	<p>1) type 속성을 지정하거나 pattern 속성을 지정하여 숫자를 형식화한다.</p>
	<p>number : ${coin }</p>
	<p>currency : <fmt:formatNumber value="${coin }" type="currency"/> </p>
	<p>percent : <fmt:formatNumber value="${coin }" type="percent"/> </p>
	<p>pattern : <fmt:formatNumber value="${coin }" pattern="000000.00"/> </p>
</body>
</html>