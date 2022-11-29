<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Model Attribute 20221129</title>
</head>
<body>
	<h3>3. @ModelAttribute 어노테이션</h3>
	
	<p>
		요청 View : registerModelAttributeForm.jsp<br/>
		컨트롤러 : ModelAttributeMemberController
	</p>
	
	<p>1) 기본자료형은 매개변수로 선언하더라도 기본적으로 전달되지 않는다.</p>
	<form action="/modelattribute/register01" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="submit" value="register01"/><br/>
	</form><br/>
	
	<p>2) 기본 자료형인 매개변수에  @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.</p>
	<form action="/modelattribute/register02" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="submit" value="register02"/><br/>
	</form><br/>
	
	<p>3) 기본 자료형인 매개변수가 여러 개인 경우 각각의 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.</p>
	<form action="/modelattribute/register03" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="submit" value="register03"/><br/>
	</form><br/>
	
	<p> 4) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다.</p>
	<form action="/modelattribute/register04" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="submit" value="register04"/><br/>
	</form><br/>
	
	<p> 5) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다. (2)</p>
	<form action="/modelattribute/register05" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		postCode : <input type="text" name="address.postCode" value="12345"/><br/>
		location : <input type="text" name="address.location" value="대전시"/><br/>
		<input type="submit" value="register05"/><br/>
	</form><br/>
	
</body>
</html>