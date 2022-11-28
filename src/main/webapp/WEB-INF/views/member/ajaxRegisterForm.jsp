<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Register Form 1128</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	// 나중에 개발할때 이렇게 선언하면 서버에 우선 올려주고 호출해서 쓰는 것
	// 데이터 메모리 때문에 이렇게 고고 이런 부분을 고민해야함 나중에는 메모리 가용!
	var registerBtn01 = $("#registerBtn01");
	var registerBtn02 = $("#registerBtn02");
	var registerBtn03 = $("#registerBtn03");
	var registerBtn04 = $("#registerBtn04");
	var registerBtn05 = $("#registerBtn05");
	var registerBtn06 = $("#registerBtn06");
	var registerBtn07 = $("#registerBtn07");
	var registerBtn08 = $("#registerBtn08");
	var registerBtn09 = $("#registerBtn09");
	
	//1) URL 경로 상의 경로 변수 값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.
	
	registerBtn01.on("click", function() {
		$.get("/ajax/register/hongkd", function(result) {
			console.log("result : " + result );
			if(result === "SUCCESS"){
				alert("SUCCESS")
			}
		})
	})

	// 2) URL 경로 상의 여러개의 경로 변수 값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다
	registerBtn02.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject ={
			userId : userIdVal,
			password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register/hongkd/pw01",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 3) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다
	registerBtn03.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject ={
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register03",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 4) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.
	registerBtn04.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject ={
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register04",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 5) 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다
	registerBtn05.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject ={
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register05?userId=" + userIdVal,
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와
	//	  @ReauestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	registerBtn06.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject ={
				userId : userIdVal,
				password : passwordVal
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register06/" + userIdVal,
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 7) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @ReauestBody 어노테이션을 지정하여 처리한다.
	registerBtn07.on("click", function() {
		var userObject = [
			{userId : "name01", password : "pw01"},
			{userId : "name02", password : "pw02"}
		]
		
		$.ajax({
			type : "post",
			url : "/ajax/register07",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 8) 중첩된 객체 배열 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다
	registerBtn08.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject = {
				userId : userIdVal,
				password : passwordVal,
				address : {
					postCode : "010908",
					location : "Daejeon"
				}
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register08",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	// 9) 중첩된 객체 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다
	registerBtn09.on("click", function() {
		var userIdVal = $("#userId").val();
		var passwordVal = $("#password").val();
		
		var userObject = {
				userId : userIdVal,
				password : passwordVal,
				cardList : [
					{no : "12345", validMonth : "20221128"},
					{no : "54321", validMonth : "20220101"}
				]
		}
		
		$.ajax({
			type : "post",
			url : "/ajax/register09",
			data : JSON.stringify(userObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS")
				}
			}
		})
	})
	
	
	
	
});

</script>
<body>
	<h3>9. Ajax 방식 요청 처리</h3>
	<hr/>
	<form >
		<p>userId : <input type="text" name="userId" id="userId" value="hongkd"/> </p>
		<p>password : <input type="text" name="password" id="password" value="1234"/> </p>
	</form>
	
	<p>1) URL 경로 상의 경로 변수 값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.</p>
	<button id="registerBtn01">registerBtn01</button>

	<p>2) URL 경로 상의 여러개의 경로 변수 값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.</p>
	<button id="registerBtn02">registerBtn02</button>
	
	<p>3) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.</p>
	<button id="registerBtn03">registerBtn03</button>
	
	<p style="color: red;">4) 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.</p>
	<button id="registerBtn04">registerBtn04</button>
	
	<p>5) 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다.</p>
	<button id="registerBtn05">registerBtn05</button>
	
	<p>
		6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 <br/>
		@ReauestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	</p>
	<button id="registerBtn06">registerBtn06</button>
	
	<p>7) 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @ReauestBody 어노테이션을 지정하여 처리한다. </p>
	<button id="registerBtn07">registerBtn07</button>
	
	<p>8) 중첩된 객체 배열 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다. </p>
	<button id="registerBtn08">registerBtn08</button>
	
	<p>9) 중첩된 객체 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다. </p>
	<button id="registerBtn09">registerBtn09</button>
	<hr/>
	
	<p>
		@RequestBody 를 사용하면 넘기는 파라미터가 받는 파라미터의 객체 속성으로 포함되어 있다면 객체를 자동으로 생성해준다 <br/>
		Member, List제네릭, Map제네릭 등등
	</p>
	
</body>
</html>