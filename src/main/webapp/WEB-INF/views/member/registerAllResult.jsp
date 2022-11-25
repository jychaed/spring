<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	유저 ID : ${allMember.userId } <br/>
	패스워드 : ${allMember.password } <br/>
	이름 : ${allMember.userName } <br/>
	E-Mail : ${allMember.email } <br/>
	생년월일 : ${allMember.dateOfBirth } <br/>
	성별 : ${allMember.gender } <br/>
	개발자여부 : ${allMember.developer }  <br/>
	외국인여부 : ${allMember.foreigner } <br/>
	국적 : ${allMember.nationality } <br/>
	소유차량: ${allMember.cars } <br/>
	취미 : ${allMember.hobby } <br/>
	우편번호 : ${allMember.postCode } <br/>
	주소 : ${allMember.address }  <br/>
	카드번호 : ${allMember.cardNo } <br/>
	유효년월 : ${allMember.validMonth } <br/>
	소개 : ${allMember.introduction } <br/>
</body>
</html>