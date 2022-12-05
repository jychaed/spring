<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Free Board Read</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnModify").on("click", function() {
		$("#delForm").attr("action", "/crud/free/modify");
		$("#delForm").attr("method", "get");
		$("#delForm").submit();
	});
	
	$("#btnDelete").on("click", function() {
		if(confirm("정말로 삭제?")){
			$("#delForm").submit();
		}else{
			$("#delForm").reset();
		}
	})
	
	$("#btnList").on("click", function() {
		location.href = "/crud/free/list";
	});
	
	
})
</script>
<body>
	<h2> Free Board Read</h2>
	<table>
		<tr>
			<td>제목</td>
			<td>${board.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${board.regDate }</td>
		</tr>
	</table>
	<form action="/crud/free/remove" id="delForm" method="post" >
		<input type="hidden" name="boardNo" value="${board.boardNo }">
	</form>
	<div>
		<button type="button" id="btnModify">수정</button>
		<button type="button" id="btnDelete">삭제</button>
		<button type="button" id="btnList">목록</button>
	</div>
</body>
</html>