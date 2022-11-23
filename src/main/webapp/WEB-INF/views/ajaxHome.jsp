<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>AJAX HOME</title>
</head>
<script type="text/javascript">
$(function () {
	// 5.  Headers 매핑
	// 요청 헤더값을 지정하지 않고 전송
	$("#putBtn").on("click", function() {
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content	: contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	$("#putHeaderBtn").on("click", function () {
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content	: contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put", // 방식 content 타입과 body를 구분 명시, contentType 과 body 선언
			url : "/board/" + boardNoVal,
			// X-HTTP-Method-Override 요청 헤더값을 PUT으로 지정합니다.
			headers : {
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	// Content-Type
	// HTTP MEssage(요청, 응답)에 담긴 데이터 형식을 정의하는 헤더
	$("#postBtn").on("click", function () {
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content	: contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "post", 
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	$("#putContentTypeJsonBtn").on("click", function () {
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				boardNo : boardNoVal,
				title : titleVal,
				content	: contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put", 
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	$("#putContentTypeXmlBtn").on("click", function () {
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var xmlData = "";
		xmlData += "<BoardNo>";
		xmlData += "<BoardNo>" + boardNoVal + "</BoardNo>";
		xmlData += "<title>" + titleVal + "</title>";
		xmlData += "<content>" + contentVal + "</content>";
		xmlData += "<writer>" + writerVal + "</writer>";
		xmlData += "<regData>2022-10-12 </regData>";
		xmlData += "</BoardNo>";
		
		
		$.ajax({
			type : "put", 
			url : "/board/" + boardNoVal,
			data : xmlData,
			contentType : "application/xml; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	// 7. Accept 매핑
	$("#getBtn").on("click", function() {
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		// GET 방식 비동기 HTTP 요청수행
		$.get("/board/" + boardNoVal, function (data) {
			console.log(data);
			alert(JSON.stringify(data));
			
		});
	});
	
	$("#getJsonBtn").on("click", function() {
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.ajax({
			type : "get", 
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/json"
			},
			success : function(result) {
				console.log("result : " + result);
				alert(JSON.stringify(result));
			}
		});
	});
	
	$("#getXmlBtn").on("click", function() {
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		$.ajax({
			type : "get", 
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/xml"
			},
			success : function(result) {
				console.log("result : " + result);
				alert(xmlToString(result)); 
			}
		});
	});
	
})

function xmlToString(xmlData) {
	var xmlString;
	
	// window.ActicXObject 는 ActicXObject를 지원하는 브라우저면
	// Object를 리턴하고 그렇지 않다면 null을 리턴합니다.
	if(window.ActicXObject){
		xmlString = xmlData.xml;
	}else{
		// 파싱된 XML 데이터를 String으로 변환합니다.
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}

</script>
<body>
	<h3>HOME & AJAX Home</h3>

	<form>
		<p>boardNo : <input type="text" name="boardNo" id="boardNo"/> </p>
		<p>title : <input type="text" name="title" id="title"/> </p>
		<p>
			content : <textarea rows="10" cols="30"></textarea>
		</p>
		<p>writer : <input type="text" name="writer" id="writer"/> </p>
		<p><input type="button" id="submitbtn" value="전송"/> </p>
	</form>

	<div>
		<h4>Headers Mapping Button Group</h4>
		<button id="putBtn">MODIFY(PUT)</button>
		<button id="putHeaderBtn">MODIFY(PUT WITH HEADER)</button>
		<br/>
		<h4>Content-Type Button Group</h4>
		<button id="postBtn">MODIFY(POST)</button>
		<button id="putContentTypeJsonBtn">MODIFY(PUT WITH contentType Json)</button>
		<button id="putContentTypeXmlBtn">MODIFY(PUT WITH contentType Xml)</button>
		<br/>
		<h3>Accept Button Group</h3>
		<button id="getBtn">READ</button>
		<button id="getJsonBtn">READ(JSON)</button>
		<button id="getXmlBtn">READ(XML)</button>
	</div>

	
</body>
</html>