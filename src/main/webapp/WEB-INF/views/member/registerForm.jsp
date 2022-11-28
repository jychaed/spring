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
 	
 	<h4>4. 요청처리 자바빈즈</h4>
 	<hr/>
 	<p>1) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
 	<form action="/beans/register01" method="post">
 		<p>userId : <input type="text" name="userId" value="honkd"/></p>
 		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="registerJavaBeans01"/> </p>
 	</form><br/>
 	
 	<p>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.</p>
 	<form action="/beans/register02" method="post">
 		<p>userId : <input type="text" name="userId" value="honkd"/></p>
 		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="registerJavaBeans02"/> </p>
 	</form><br/>
 	
 	<p>3) 여러개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.</p>
 	<form action="/beans/register03" method="post">
 		<p>uid : <input type="text" name="uid" value="50"/></p>
 		<p>userId : <input type="text" name="userId" value="honkd"/></p>
 		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>coin : <input type="text" name="coin" value="100"/> </p>
		<p><input type="submit" value="registerJavaBeans03"/> </p>
 	</form><br/>
 	
 	<h4>5. Date 타입 처리</h4>
 	<hr/>
 	<p>
		1) 쿼리 파라미터(dateOfBirth=1234)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다<br/>
		<font style="color: red;">400-Bad Request 에러발생</font>
	</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=1234" >
		/registerByGet01?userId=hongkd&dateOfBirth=1234
	</a><br/>
	
 	<p>
		2) 쿼리 파라미터(dateOfBirth=2018-09-08)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다<br/>
		<font style="color: red;">400-Bad Request 에러발생</font>
	</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2018-09-08" >
		/registerByGet01?userId=hongkd&dateOfBirth=2018-09-08
	</a><br/>
	
 	<p>
		3) 쿼리 파라미터(dateOfBirth=20180908)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다<br/>
		<font style="color: red;">400-Bad Request 에러발생</font>
	</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=20180908" >
		/registerByGet01?userId=hongkd&dateOfBirth=20180908
	</a><br/> <!-- @DateTimeFormat(pattern = "yyyyMMdd") 이걸 컨트롤러에 추가해서 이제 됩니당 -->
	
 	<p>
		4) 쿼리 파라미터(dateOfBirth=2018/09/08)로 전달 받은 값이 날짜 문자열 형식에 맞아 Date타입으로 변환에 성공한다<br/>
		<font style="color: green;">성공</font>
	</p>
	<a href="/registerByGet01?userId=hongkd&dateOfBirth=2018/09/08" >
		/registerByGet01?userId=hongkd&dateOfBirth=2018/09/08
	</a><br/>
	
 	<p>
		5) Member 매개변수와 쿼리 파라미터(dateOfBirth=20180908)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다<br/>
		<font style="color: red;">400-Bad Request 에러발생</font>
	</p>
	<a href="/registerByGet02?userId=hongkd&dateOfBirth=20180908" >
		/registerByGet02?userId=hongkd&dateOfBirth=20180908
	</a><br/>
	
	<p>폼 형식으로 요청</p>
 	<form action="/register" method="post">
 		<p>userId : <input type="text" name="userId" value="honkd"/></p>
 		<p>password : <input type="text" name="password" value="1234"/> </p>
		<p>dateOfBirth : <input type="text" name="dateOfBirth" value="20180908"/> </p>
		<p><input type="submit" value="register"/> </p>
 	</form><br/>
 	
 	<h4>6. @DateTimeFormat 어노테이션</h4>
 	<p>Member 클래스의 dateOfBirth 속성에 @DateTimeFormat 어노테이션 추가 후 패턴 (yyyMMdd)을 적용합니다.</p>
 	<p>5번 처리 부분을 이용하여 테스트 하기 때문에 아래처리를 위한 도구는 따로 만들지 않습니다.</p>
 	<hr/> <!-- 5번 이거 하니 이제 에러 안납니당 ㅎㅎ -->
 	
 	
 	<h4>7. 폼방식 요청 처리</h4>
 	<p>1) 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registeruserId" method="post">
 		<p>userId : <input type="text" name="userId" /></p>
		<p><input type="submit" value="registeruserId"/> </p>
 	</form><br/>
 	
 	<p>2) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
 	<form action="/registerMemberUserId" method="post">
 		<p>userId : <input type="text" name="userId" /></p>
		<p><input type="submit" value="registerMemberUserId"/> </p>
 	</form><br/>
 	
 	<p>3) 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다.</p>
 	<form action="/registerPassword" method="post">
 		<p>password : <input type="password" name="password" /></p>
		<p><input type="submit" value="registerPassword"/> </p>
 	</form><br/>
 	
 	<p>4) 폼 라디오 버튼 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerRadio" method="post">
 		<p>gender : </p>
 		<p><input type="radio" name="gender" value="male" /> Male </p>
 		<p><input type="radio" name="gender" value="female" checked="checked"/> Female </p>
 		<p><input type="radio" name="gender" value="other" /> Other </p>
		<p><input type="submit" value="registerRadio"/> </p>
 	</form><br/>
 	
 	<p>5) 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerSelect" method="post">
 		<p>nationality</p>
 		<select name="nationality">
 			<option>☆선택해주세요☆</option>
 			<option value="korea">대한민국</option>
 			<option value="germany">독일</option>
 			<option value="austrailia">호주</option>
 			<option value="canada">캐나다</option>
 			<option value="japan">일본</option>
 		</select>
 		<p><input type="submit" value="registerSelect"/> </p>
 	</form><br/>
 	
 	<p>6) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerMultiSelect01" method="post">
 		<p>cars</p>
 		<select name="cars" multiple="multiple">
 			<option value="jeep">JEEP</option>
 			<option value="volvo">VOLVO</option>
 			<option value="bmw">BMW</option>
 			<option value="audi">AUDI</option>
 		</select>
 		<p><input type="submit" value="registerMultiSelect01"/> </p>
 	</form><br/>
 	
 	<p>7) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</p>
 	<form action="/registerMultiSelect02" method="post">
 		cars: <br/>
 		<select name="carArray" multiple="multiple">
 			<option value="ferrari">FERRARI</option>
 			<option value="porsche">PORSCHE</option>
 			<option value="jeep">JEEP</option>
 			<option value="volvo">VOLVO</option>
 			<option value="bmw">BMW</option>
 			<option value="audi">AUDI</option>
 		</select>
 		<p><input type="submit" value="registerMultiSelect02_Arr"/> </p>
 	</form><br/>
 	
 	<p>8) 복수 선택이 가능한 폼 셀렉트 박스 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
 	<form action="/registerMultiSelect03" method="post">
 		cars: <br/>
 		<select name="carList" multiple="multiple">
 			<option value="ferrari">FERRARI</option>
 			<option value="porsche">PORSCHE</option>
 			<option value="jeep">JEEP</option>
 			<option value="volvo">VOLVO</option>
 			<option value="bmw">BMW</option>
 			<option value="audi">AUDI</option>
 		</select>
 		<p><input type="submit" value="registerMultiSelect03_List"/> </p>
 	</form><br/>
 	
 	<p>9) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerCheckbox01" method="post">
 		hobby: <br/>
 		<input type="checkbox" name="hobby" value="sports"/> Sports<br/>
 		<input type="checkbox" name="hobby" value="music"/> Music<br/>
 		<input type="checkbox" name="hobby" value="movie"/> Movie<br/>
 		<input type="checkbox" name="hobby" value="game"/> Game<br/>
 		<input type="checkbox" name="hobby" value="development"/> Development<br/>
 		<input type="submit" value="registerCheckbox01"/> 
 	</form><br/>
 	
 	<p>10) 폼 체크박스 요소값을 문자열 배열 타입 매개변수로 처리한다.</p>
 	<form action="/registerCheckbox02" method="post">
 		hobby: <br/>
 		<input type="checkbox" name="hobbyArray" value="sports"/> Sports<br/>
 		<input type="checkbox" name="hobbyArray" value="music"/> Music<br/>
 		<input type="checkbox" name="hobbyArray" value="movie"/> Movie<br/>
 		<input type="checkbox" name="hobbyArray" value="game"/> Game<br/>
 		<input type="checkbox" name="hobbyArray" value="development"/> Development<br/>
 		<input type="submit" value="registerCheckbox02_Arr"/> 
 	</form><br/>
 	
 	<p>11) 폼 체크박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.</p>
 	<form action="/registerCheckbox03" method="post">
 		hobby: <br/>
 		<input type="checkbox" name="hobbyList" value="sports"/> Sports<br/>
 		<input type="checkbox" name="hobbyList" value="music"/> Music<br/>
 		<input type="checkbox" name="hobbyList" value="movie"/> Movie<br/>
 		<input type="checkbox" name="hobbyList" value="game"/> Game<br/>
 		<input type="checkbox" name="hobbyList" value="development"/> Development<br/>
 		<input type="submit" value="registerCheckbox03_List"/> 
 	</form><br/>
 	
 	
 	<p>12) 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerCheckbox04" method="post">
 		developer: <br/>
 		<input type="checkbox" name="developer" value="Y"/><br/>
 		<input type="submit" value="registerCheckbox04"/> 
 	</form><br/>
 	
 	
 	<p>13) 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.</p>
 	<form action="/registerCheckbox05" method="post">
 		developer: <br/>
 		<input type="checkbox" name="foreigner" value="true"/><br/>
 		<input type="submit" value="registerCheckbox05"/> 
 	</form><br/>
 	
 	<p>14) 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다</p>
 	<form action="/registerAddress" method="post">
 		postCode: <input type="text" name="postCode" ><br/>
 		location: <input type="text" name="location" ><br/>
 		<input type="submit" value="registerAddress"/> 
 	</form><br/>
 	
 	<p>15) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
 	<form action="/registerUserAddress" method="post">
 		address.postCode: <input type="text" name="address.postCode" ><br/>
 		address.location: <input type="text" name="address.location" ><br/>
 		<input type="submit" value="registerUserAddress"/> 
 	</form><br/>
 	
 	<p>16) 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다.</p>
 	<form action="/registerUserCardList" method="post">
 		카드1 - 번호 : <input type="text" name="cardList[0].no"></br>
 		카드1 - 유효년월 : <input type="text" name="cardList[0].validMonth"></br>
 		카드2 - 번호 : <input type="text" name="cardList[1].no"></br>
 		카드2 - 유효년월 : <input type="text" name="cardList[1].validMonth"></br>
 		<input type="submit" value="registerUserCardList"/> 
 	</form><br/>
 	
 	<p>17) 폼 텍스트 영역 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.</p>
 	<form action="/registerTextArea" method="post">
 		introduction : <br/>
 		<textarea rows="6" cols="100" name="introduction"></textarea></br>
 		<input type="submit" value="registerTextArea"/> 
 	</form><br/>
 	
 	<p>18) 폼 텍스트 영역 요소값을 Date 타입 매개변수로 처리한다.</p>
 	<p>날짜 문자열 형식을 yyyy/MM/dd 형식으로 지정하지 않으면 에러가 발생한다</p>
 	<p>날짜 문자열 형식을 내가 원하는 형태로 바꾸려면 @DatetimeFormat 어노테이션을 사용한다</p>
 	<form action="/registerDate01" method="post">
 		dateOfBirth : <input type="text" name="dateOfBirth"><br/>
 		<input type="submit" value="registerDate01"/> 
 	</form><br/>


	<!-- 8.  파일 업로드 폼 방식 요청 처리 -->
	<!-- 
		파일 업로드가 에러나는 경우 조치방법
		0) 클린!!! 강조
		1) 파일 업로드에 필요한 라이브러리가 추가되었는지 pom.xml 확인
		2) web.xml 에 MultipartFile을 돕는 필터를 추가한다.
		
		## 위 내용을 다 적용했는데도 안될 시만
		2) server > context.xml 수정
			- Contenxt 태그에 allowCasualMultipartParsing="true" path="/"추가
	 --> 
	<h4>8. 파일업로드 폼 방식 요청 처리</h4>
	<p>1) 파일 업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개 변수로 처리한다</p>
	<form action="/registerFile01" method="post" enctype="Multipart/form-data">
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 
	<!-- //20221128 	 -->
	<p>2) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개 변수와 문자열 매개변수로 처리한다</p>
	<form action="/registerFile02" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	<p>3) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개 변수와 자바빈즈 매개변수로 처리한다</p>
	<form action="/registerFile03" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	<p>4) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다</p>
	<form action="/registerFile04" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="picture"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	<p>5) 여러 개의 파일 업로드를 폼 파일 요소 값을 여러개의 MultipartFile 매개변수로 처리한다</p>
	<form action="/registerFile05" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="picture"/>
		<input type="file" name="picture2"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	<p>
		6) 여러 개의 파일 업로드를 폼 파일 요소 값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다
		<font style="color: red;"></font>
	</p>
	<form action="/registerFile06" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="pictureList[0]"/>
		<input type="file" name="pictureList[1]"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 
	<!-- 6)번하고 동일한 폼이긴 하나 요청하는 URL과 받는 타입이 다르다 --> 	
	<p>7) 여러 개의 파일 업로드 폼 파일 요소 값과 텍스트 필드 요소값을 MultipartFileMember 타입의 자바빈즈 매개변수로 처리한다</p>
	<form action="/registerFile07" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="pictureList[0]"/>
		<input type="file" name="pictureList[1]"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 
	<!-- 사진파일 다중 선택시 다중으로 넘어감!!!  --> 	
	<p>7-2) 파일 업로드 폼 파일 요소 값과 텍스트 필드 요소값을 MultipartFileMember 타입의 자바빈즈 매개변수로 처리한다</p>
	<form action="/registerFile07" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="pictureList" multiple="multiple"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	<p>8) 파일 업로드 폼 파일 요소 값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다</p>
	<form action="/registerFile08" method="post" enctype="Multipart/form-data">
		<p>userId : <input type="text" name="userId" value="hongkd"> </p>
		<p>password : <input type="text" name="password" value="1234"> </p>
		<input type="file" name="pictureList" multiple="multiple"/>
		<input type="submit" value="업로드"/> 
 	</form><br/>
	 	
	 	
	 	
</body>
</html>















