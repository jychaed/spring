<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/formtag/validation</title>
</head>
<body>
 	<!-- 
 		아이디값을 비워놓고 등록을 눌렀을때, 누락된 값이르모 누락이 되었다는 메세지가 출력되야함
 		근데 출력이 되지않았다? 그이유는 validation을 하기 위한 설정이 form:error 만으로는 이뤄지지 않는다는 점입니다.
 		그렇다면 그점은 어디서 찾는 것인가? 입력값 검증이라는 시간을 통해서 에러를 아주 그냥 뿌셔보자!
 	 -->
	<h2>Spring Form</h2>
	<p>객체를 생성하여 값을 설정한 후 화면에 전달한다.</p>
	<form:form modelAttribute="member" method="post" action="/formtag/validation/result">
		<table>
			<tr>
				<td><form:label path="userId">유저ID</form:label> </td>
				<td>
					<form:input path="userId"/>
					<font color="red">
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td><form:label path="userName">이름</form:label> </td>
				<td>
					<form:input path="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
			<tr>
				<td><form:label path="email">E-Mail</form:label> </td>
				<td>
					<form:input path="email"/>
					<font color="red">
						<form:errors path="email"/>
					</font>
				</td>
			</tr>
		</table>
			<form:button name="register">등록</form:button>
	</form:form> 
</body>
</html>