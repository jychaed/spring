<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register All Form</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
// Math.random() * 10) + 1;
$(function(){
	var button1 = $("#button1");
	
	button1.on("click", function(){
		$("[name=userId]").val("a001");
		$("[name=password]").val("1234");
		$("[name=userName]").val("홍길동");
		$("[name=email]").val("ddit@naver.com");
		$("[name=dateOfBirth]").val("2019/10/10");
		$("[name=postCode]").val("12345");
		$("[name=address]").val("대전광역시 서구");
		$("[name=cardNo]").val("123123");
		$("[name=validMonth]").val("2019/10/10");
		$("[name=developer]").prop("checked", true);
		$("[name=foreigner]").prop("checked", true);
		$("[name=nationality]").val("germany").prop("selected", true);
		$("[name=cars]").val("audi").prop("selected", true);
		$("[name=cars]").val("jeep").prop("selected", true);
		$("[name=hobby]:eq(0)").prop("checked", true);
		$("[name=hobby]:eq(2)").prop("checked", true);
		$("[name=introduction]").val("반갑습니다!!!");
	});
});
</script>
<body>
	<button type="button" id="button1">자동</button>
	<h2>Register All Form</h2>
	<form action="/registerUser" method="post">
		<table border="1">
			<tr>
				<td>유저 ID</td>
				<td><input type="text" name="userId"/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="dateOfBirth"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="male" checked="checked"/>Male
					<input type="radio" name="gender" value="female"/>Female
					<input type="radio" name="gender" value="other"/>Other
				</td>
			</tr>
			<tr>
				<td>개발자여부</td>
				<td><input type="checkbox" name="developer" value="Y"/></td>
			</tr>
			<tr>
				<td>외국인여부</td>
				<td><input type="checkbox" name="foreigner" value="true"/></td>
			</tr>
			<tr>
				<td>국적</td>
				<td>
					<select name="nationality">
						<option value="korea">대한민국</option>
						<option value="germany">독일</option>
						<option value="austrailia">호주</option>
						<option value="canada">캐나다</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>소유차량</td>
				<td>
					<select name="cars" multiple="multiple">
						<option value="jeep">JEEP</option>
						<option value="volvo">VOLVO</option>
						<option value="bmw">BMW</option>
						<option value="audi">AUDI</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" value="sports"/>운동
					<input type="checkbox" name="hobby" value="music"/>음악
					<input type="checkbox" name="hobby" value="movie"/>영화
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="postCode"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr>
				<td>카드번호</td>
				<td><input type="text" name="cardNo"/></td>
			</tr>
			<tr>
				<td>유효년월</td>
				<td><input type="text" name="validMonth"/></td>
			</tr>
			<tr>
				<td>소개</td>
				<td>
					<textarea rows="10" cols="40" name="introduction"></textarea>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="등록"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="취소"/></td>
			</tr>
		</table>
	</form>
</body>
</html>