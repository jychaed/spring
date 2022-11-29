<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0901 20221129 </title>
</head>
<body>
	<h4>c:url 사용 예</h3>
	<p> 웹어플리케이션 내에서의 절대 경로를 사용하면 실제로 생성된 컨텍스트 경로가 포함된다.</p>
	<p>절대 URL</p>
	<c:url value="http://localhost/board/list"></c:url>
	<br/>
	
	<p>상대 URL - 절대 경로</p>
	<c:url value="/board/detail?bo_no=1" var="boardUrl"/>
	<br/>
		
	<p>상대 URL - 상대 경로</p> <!-- 보통은 이렇게 안주죠...! css같은거면 몰라도! -->
	<c:url value="../../board/list.jsp"/>
	<br/>
	
</body>
</html>