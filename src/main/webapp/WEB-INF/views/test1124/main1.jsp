<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 회원정보 main1.jsp</title>
</head>
<body>
	<h2>로그인 회원정보</h2>
	<p>아이디 : ${userId} </p>
	<p>이름 : ${userName} </p>
	<hr/>
	<h4>메뉴를 선택하세요</h4>
	<a href="/myBox" >1. 내 자료실 </a><br>
	<a href="/myGallery" >2. 내 갤러리 </a>
</body>
</html>