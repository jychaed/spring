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
	
	$("#item").submit(function(event) { // 폼안에 내용이 돌아갈텐데! 아작스 다돌고! 
		event.preventDefault();
		
		//form 태그 this에 담음
		var that = $(this);
		var str = "";
		// checkImgtypedata 에 a태그들!!!담긴거
		$(".uploadedList a").each(function(index) {
			var value = $(this).attr("href");
			value = value.substr(27); 		// '?fileName=' 다음에 나오는 경로가 파일명이죠!
				
			// 파일즈의 갯수만큼 히든으로 파일들을 넣어줘! 밸루는 각 파일명이 되겠죠		
			str += "<input type='hidden' name='files["+index+"]' value='"+value+"'/>";		
			
		});
		console.log("str : " + str);
		//that은 form태그잖아요? 그거 넣어줘! 만든 파일들!
		that.append(str);
		// 그리고 넣어줘요.....
		that.get(0).submit();
		
	});
	
	$("#inputFile").on("change", function(event) {
		console.log("change....!");
		
		//files는 target의 속성에 있음 
		// 배열 형태로 데이터가 저장됨
		var files = event.target.files;
		
		// 0번째에 입력한 데이터가 저장되어 있음
		var file = files[0];
		
		// 따라서, files[0]을 해서 var file에 담으면 해당 데이터가 변수에 저장됨(console창 확인)
		console.log(file);
		
		// javascript에 있는 객체: Form에 있는 data를 담을 때 사용
		var formData = new FormData();
		
		// input type=file은 무조건 append메소드 사용해서 담아줘야 함 
		// 이 때 사용한 key값이 FileUploadController에 있는 파라미터 변수명이랑 동일해야 함
		//		 ex) formData.append("file", file);  
	    // 		 -----public ResponseEntity<String> uploadAjax(MultipartFile 'file')
		formData.append("file",file);
		
		// formData는 key/value 형식으로 데이터가 저장된다.
		// dataType : 응답 (response) 데이터를 내보낼 때 보내줄 데이터 타입
		//				Controller에서 return해주는 값에 대해 설정
		// processData : 데이터 파라미터를 data라는 속성으로 넣는데, 제이쿼리 내부적으로 쿼리스트링을 구성합니다.
		//				파일 전송의 경우 쿼리스트링을 사용하지 않으므로 해당 설정을 false 합니다.
		// contentType : 파일 전송의 경우 쿼리스트링을 사용하지 않으므로 해당 설정의 기본값은 " application/x-www-form-urlencoded; charset=utf-8",
		// 				그래서, 기본값으로 나가지 않고 "multipart/form-data"로 나갈 수 있도록 설정을 false합니다.
		// request 요청에서 Content-Type을 확인해보면 "multipart/form-data; boundary=----Web....."와 같은 값으로 전송되는 걸 확인할 수 있다.
		$.ajax({
			url : "/item3/uploadAjax",
			data : formData,
			dataType : "text",
			processData : false,
			contentType : false,
			type : "POST",
			success : function(data) {
				console.log(data); // 넘어오는 데이터 파일명이 포함된!
				
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
			}
		});
	});
	
	$(".uploadedList").on("click", "span", function () { //<span>X</span> 이거 눌렀을때 이벤트
		$(this).parent("div").remove();
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
	<h2>MODIFY 20221209</h2>
	<form:form modelAttribute="item" action="/item3/modify" method="post" enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.itemId }"/>
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="itemName" id="itemName" value="${item.itemName }"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" id="price" value="${item.price }"/>
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
					<textarea rows="10" cols="30" name="description">${item.description }</textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="btnRegister">Modify</button>
			<button type="button" id="btnList">List</button>
		</div>
	</form:form>
</body>
</html>