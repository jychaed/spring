<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Register File 20221128</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	var inputFile = $("#inputFile");
	
	// Ajax 방식으로 전달한 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.
	inputFile.on("change", function(event) {
		console.log("change...!");
		00
		var files = event.target.files;
		var file = files[0];
		
		console.log(file);
		
		// idImageFileFlag(file) 메서드는 custom method로
		// 업로드된 파일이 이미지가 맞는지 여부를 확인할 수 있도록 체크해주는 메서드
		// parameter : 파일
		// return : boolean true/false
		if(idImageFileFlag(file)){
			
			// ajax로 파일을 컨트롤 할 시, formData 를 이용한다.
			//append()이용
			var formData = new FormData();
			formData.append("file", file);
			
			// formData는 key/value 형식으로 데이터가 저장된다. ("file", file)
			// dataType: 응답(response)데이터를 내보낼 때 보내줄 데이터 타입입니다.
			// processData : 데이터 파라미터를 data라는 속성으로 넣는데, 제이쿼리 내부적으로 쿼리스트링을 구성합니다.
			//				 파일 전송의 경우 쿼리스트링을 사용하지 않으므로 해당 설정을 false로 비활성화합니다.
			// contentType : Content-Type을 설정시, 사용하는데 해당 설정의 기본값은 'application/x-www-form-urlencoded; charset=utf-8'입니다.
			//				 하여, 기본값으로 나가지 않고 'multipart/form-data'로 나갈 수 있도록 설정을 false로 비활성화합니다.
			// request 요청에서 Content-Type을 확인해보면 'multipart/form-data; boundary=-----WebkitFormBoundary7Rap4TfboPbSzm2q'
			// 와 같은 값으로 전송된 것을 확인할 수 있습니다.
			
			$.ajax({
				type : "post",
				url : "/ajax/uploadAjax",
				data : formData,
				dataType : "text",
				processData : false,
				contentType : false,
				success : function(data) {
					alert(data);
					if(data == "UPLOAD SUCCESS"){
						var file = event.target.files[0];
						var reader = new FileReader();
						reader.onload = function(e) {
							$("#preview").attr("src", e.target.result);
						}
						reader.readAsDataURL(file);
					}
				}
			});
		}else{
			alert("이미지 넣어줘...!")
		}
	})
});

function idImageFileFlag(file) {
	var ext = file.name.split(".").pop().toLowerCase(); // 파일명에서 확장자를 가져옵니다.
	return ($.inArray(ext, ["jpg", "jpeg", "gif", "png"]) === -1) ? false : true;
	
} 

</script>
<body>
	<h1>10. 파일업로드 Ajax 방식 요청 처리</h1>
	<hr/>
	
	<p>Ajax 방식으로 전달한 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.</p>
	<div>
		<input type="file" id="inputFile"><br/>
		<hr/>
		<img id="preview">
	</div>
	
</body>
</html>