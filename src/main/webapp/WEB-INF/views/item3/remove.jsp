<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item3 MODIFY</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#btnList").on("click", function() {
		location.href = "/item3/list";
	});
	
	var itemId = ${item.itemId};
	console.log("itemId : " + itemId);
	
	$.getJSON("/item3/getAttach/" + itemId, function(list) {
		$(list).each(function() {
			console.log("data : "+ this);
			var data = this;
			var str = "";
			
			if(checkImageType(data)){ 	// 이미지면 이미지 태그를 이용하여 출력
				str += "<div>";
				str += "	<a href='/item3/displayFile?fileName=" + data + "'>";
				str += "		<img src='/item3/displayFile?fileName=" + getThumbnailName(data)+ "'/>";
				str += "	</a>";
				str += "	<span>X</span>";
				str += "</div>";
			}else { // 이미지가 아니면 그냥 이름이랑 같이 출력
				str += "<div>";
				str += "   <a href='/item3/displayFile?fileName=" + data + "'>"+getOriginalName(data)+"</a>";
				str += "   <span>X</span>";
				str += "</div>";
			}
			$(".uploadedList").append(str);
			
		});
	});
	
		
	function getOriginalName(fileName) {
		if(checkImageType(fileName)){
			return;
		}
		var idx = fileName.indexOf('_') + 1;
		return fileName.substr(idx);
	}
	
	function getThumbnailName(fileName) {
		var front = fileName.substr(0,12);
		var end = fileName.substr(12);
		
		console.log("front : " + front);
		console.log("end : " + end);
		
		return front + "s_" + end;
	}
	function checkImageType(fileName) {
 		var pattern = /jpg|gif|png|jpeg/i; // i는대소문자구분 
		return fileName.match(pattern);  // 패턴과 일치하면 true (이미지니? 이미지구나 넌 그냥 들어올 수 있단다  . . . .)
	}
	
});
</script>
<body>
	<h2>REMOVE 20221209</h2>
	<form:form modelAttribute="item" action="/item3/remove" method="post" enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.itemId }"/>
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="itemName" id="itemName" value="${item.itemName }" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" id="price" value="${item.price }" disabled="disabled"/>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" id="inputFile"/> <!-- 비동기라서! 처리 뭐안함 -->
					<div class="uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name="description" disabled="disabled">${item.description }</textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="btnRemove">Remove</button>
			<button type="button" id="btnList">List</button>
		</div>
	</form:form>
</body>
</html>