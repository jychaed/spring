<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0101 20221129</title>
</head>
<body>
	<h3>4.표현언어(EL)</h3>
	<p>1) 자바빈즈 프로퍼티를 조회하는 경우 '속성명.프로퍼티명'을 지정한다.</p>
	<table border="1">
		<tr>
			<td>\${member.userId }</td> <!-- userId 프로퍼티라고 하지만 게터임 결과적ㅇ론... get 날리고 그 바로 뒤 대문자였던게 소문자됨 -->
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>\${member.password }</td>
			<td>${member.password }</td>
		</tr>
		<tr>
			<td>\${member.userName }</td>
			<td>${member.userName }</td>
		</tr>
		<tr>
			<td>\${member.email }</td>
			<td>${member.email }</td>
		</tr>
		<tr>
			<td>\${member.dateOfBirth }</td>
			<td>${member.dateOfBirth }</td>
		</tr>
	</table>
</body>
</html>