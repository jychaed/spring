<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Form</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
   $(function() {
      var board = $("#board");   // form:form태그에서 modelAttribute="board"를 이렇게 아이디로 인식해 사용할 수 있다. 따로 아이디 지정도 가능~
      
      $("#btnRegister").on("click", function() {
         if($("#title").val() == null || $("#title").val() == "") {
            alert("제목을 입력해 주세요!");
            return false;
         }
         
         if($("#writer").val() == null || $("#writer").val() == "") {
            alert("작성자를 입력해 주세요!");
            return false;
         }
         
         if($("#btnRegister").text() == "수정") {
            board.attr("action", "/crud/board/modify");
         }
         
         board.submit();
      });
      
      
      $("#btnList").on("click", function() {
         location.href="/crud/board/list";
      });
      
      
   });
</script>
<body>
   	<h2>REGISTER</h2>
	<form:form modelAttribute="board" action="/crud/board/register"
		method="post">
		<c:if test="${status eq 'u' }">

			<input type="hidden" name="boardNo" value="${board.boardNo }" />
		</c:if>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title"
					value="${board.title }" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="writer" name="writer"
					value="${board.writer }" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="6" cols="30" id="content" name="content">${board.content }</textarea></td>
			</tr>
		</table>
	</form:form>
	<div>
      <!-- 처음에는 등록버튼이었다가 status가 u(컨트롤러의 modify메서드에서 담음)를 담아오면 수정버튼으로 바뀜. -->
      <c:set var="buttonText" value="등록"/>
      <c:if test="${status eq 'u' }">
         <c:set var="buttonText" value="수정"/>
      </c:if>
      <button type="submit" id="btnRegister">${buttonText }</button>
      <button type="button" id="btnList">목록</button>
   </div>
   
</body>
</html>