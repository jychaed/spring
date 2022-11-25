<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myGallery.jsp</title>
</head>
<body>
	<h2>갤러리</h2>
	<c:choose>
		<c:when test="${empty fileList }">
			<p>조회할 사진이 존재하지 않습니다.</p>
		</c:when>
		<c:otherwise>
				<p>- myGallery</p>
			<c:forEach items="${fileList }" var="filenames">
				<img style= "width:120px;" alt="error" src="../resources/mybox/image/${filenames }"><br/>
				<a href="#"> [↑다운로드↑]</a><br/>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>

