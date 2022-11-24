<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm</title>
</head>
<body>
<!-- 요청된 데이터가 넘어오는 방식 여러개 해보자! 20221124 -->
	<h1>register Form</h1>
	<hr/>
	<!-- 5장. 컨트롤러 요청 처리 -->
	<!-- 1. 컨트롤러 메서드 매개변수 & 요청처리 -->
	
	<!-- 1) -->
	<p>1) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.</p>
	<a href="/register?userId=hongkd&password=1234" >/register?userId=hongkd&password=1234</a>
	<hr/>
	
	<!-- 2) -->
	<p>2) URL 경로 상의 경로 변수로 부터 요청 데이터를 취득할 수 <font style="color: red;">없다.</font></p>
	<a href="/register/hongkd" >/register/hongkd</a>
	<hr/>
	
	<!-- 3) -->
	<p>3) HTML Form 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</p>
	<form action="/register01" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register01"/> </p>
 	</form>
 	<hr/>
 	
	<!-- 4) -->
	<p>4) HTML Form 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.</p>
	<form action="/register02" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register02"/> </p>
 	</form>
 	<hr/>
 	
 	<!-- 5) -->
 	<p>5) HTML Form 필드가 여러개일 경우에 컨트롤러 매개변수의 위치는 상관없다.</p>
 	<form action="/register03" method="post">
		<p>uid : <input type="text" name="uid" value="50"/> </p>
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register03"/> </p>
 	</form>
 	<hr/>
 	
 	<!-- 6) -->
 	<p>6) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.</p>
 	<form action="/register04" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register04"/> </p>
 	</form>
 	<hr/>
 	
 	<!-- 7) -->
 	<p>7) HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 요청 데이터를 취득한다.</p>
 	<form action="/register05" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register05"/> </p>
 	</form>
 	<hr/>
 	
 	
 	
 	
 	<!-- 3. 요청 데이터 처리 어노테이션 -->
	<h4>3. 요청 데이터 처리 어노테이션</h4>
 	<hr/>
 	<p>1) URL 경로 상의 경로 변수로 부터 요청 데이터를 취득할 수 있다.</p>
 	<a href="/register/hongkd" >/register/hongkd</a><br/>
 	
 	<p>2) URL 경로 상의 경로 변수가 여러 개일때 @PathVariable어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.</p>
 	<a href="/register/hongkd/100" >/register/hongkd/100</a><br/>
 	
 	<p>3) URL 폼의 필드명과 컨트롤러 매개변수명이 일치하면 요청을 처리할 수 있다.</p>
 	<form action="/register0101" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register0101"/> </p>
 	</form><br/>
 	
 	<p>4) URL Form 필드명과 컨트롤러 매개변수명이 일치(대소문자구분)하지않으면 요청을 처리할 수 없다.</p>
 	<form action="/register0201" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register0201"/> </p>
 	</form><br/>
 	
 	<p>5) @RequestParms 어노테이션을 사용하여 특정한 HTML form의 필드명을 지정하여 요청을 처리한다.</p>
 	<form action="/register0202" method="post">
		<p>userId : <input type="text" name="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="register0202"/> </p>
 	</form><br/>
 	
</body>
</html>