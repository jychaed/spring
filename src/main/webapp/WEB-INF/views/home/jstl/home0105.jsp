<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0105 20221129</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>JSTL 태그들의 Example ::: c:out</p>
	<p>value 속성에 지정한 값이 존재하지 않으면 default 속성에 지정한 값이 출력된다.</p>
	<table border="1">
		
		<tr>
			<td>member.userId</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>member.userId</td>
			<td><c:out value="${member.userId }" default="hongkd"/></td> <!-- 넘겨받은  value="${member.userId }"member.setUserId("<p>hongkd<>&%0102</p>"); 없으면 default 출력 -->
		</tr>
		
		
	</table>
</body>
</html>