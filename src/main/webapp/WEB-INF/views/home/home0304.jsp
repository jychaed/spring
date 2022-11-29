<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home 0303</title>
</head>
<body>
   <h3>4. 표현언어(EL)</h3>
   <p>4-3) empty 연산자를 이용한 예제 </p>
   <table border="1">
      <tr>
         <td>\${empty member }</td>
         <td>${empty member }</td>
      </tr>
     
      <tr>
         <td>\${empty member.userId }</td>
         <td>${empty member.userId }</td>
      </tr>
      
      <tr>
      	 <td>\${member.userId }</td>
         <td>${member.userId }</td>
      </tr>
      
   </table>
</body>
</html>