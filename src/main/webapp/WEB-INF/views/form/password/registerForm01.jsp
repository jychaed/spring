<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/formtag/password</title>
</head>
<body>
	<h2>Spring Form</h2>
	<p>1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다</p>
	<form:form modelAttribute="member" method="post" action="/formtag/register">
		<table>
			<tr>
				<td>비밀번호</td>
				<td>
					<form:password path="password"/>
					<font color="red">
						<form:errors path="password"/>
					</font>
				</td>
			</tr>
			
		</table>
		<form:button name="register">등록</form:button>
	</form:form> 
</body>
</html>