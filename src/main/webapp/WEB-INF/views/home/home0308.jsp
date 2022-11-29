<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home 0308 20221129</title>
</head>
<body>
   <h3>4. 표현언어(EL)</h3>
   <p>4-8) empty 연산자를 이용한 예제 </p>
   <table border="1">
      <tr>
         <td>\${empty member }</td>
         <td>${empty member }</td>
      </tr>
     
      <tr>
         <td>\${empty member.hobbyList }</td>
         <td>${empty member.hobbyList }</td>
      </tr>
      
      <tr>
      	 <td>\${member.hobbyList }</td>
         <td>${member.hobbyList }</td>
      </tr>
      
   </table>
</body>
</html>