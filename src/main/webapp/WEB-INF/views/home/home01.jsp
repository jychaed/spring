<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home01 20221129</title>
</head>
<body>
	<!-- 
		7장. JSP
		
		1. 지시자
		지시자(directive)는 JSP페이지에 대한 설정 정보를 지정할 때 사용한다.
		JSP가 제공하는 지시자에는 page지시자, taglib지시자, include 지시자로 세가지가 있습니다.
		
			 page지시자
			 JSP 페이지에 대한 정보를 지정합니다.
			 - contentType : JSP가 생성할 문서의 MINE 타입과 문자 코드를 지정합니다.
			 - pageEmcoding : JSP 페이지 자체의 문자 코드를 지정합니다.
			 - session : JSP 페이지가 세션을 사용할지의 여부를 지정합니다.
			 - import : JSP 페이지에서 사용할 자바 클래스를 지정합니다.
			 
			 taglib지시자
			 JSP 페이지에서 사용할 태그 라이브러리를 지정합니다.
			 - prefix : 태그 라이브러리를 호출할 때 사용할 접두어를 지정합니다.
			 - url : TLD 파일이 위치한 URL 혹은 파일경로를 지정합니다.
			 
			 include 지시자
			 JSP 페이지의 특정 영역에 다른 문서를 포함합니다.
			 - file : 포함할 파일의 경로를 지정합니다.
		
		:::: 스크립트릿
		2. 스크립트릿
		스크립트릿(Scriptlet)은 JSP	페이지에서 자바코드를 실행할 때 사용하는 코드이 블록입니다
		스크립트릿 코드 블록은 "&#60;&#37; &#37;&#62;"사이, 그리고"&#60;&#37;&#61; %&#62; 사이에 자바코드를 포함할 수 있습니다.
		현재는 스크립트릿을 사용하기 보다는 JSTL과 같은 커스텀 태그라이브러리와 EL을 조합해서 JSP를 구현하는 방법을 많이 사용합니다
			 
		
	 -->
	<%
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.KOREA);
		String formatterDate = dateFormat.format(date);
		String serverTime = formatterDate;
	
	%>
	<!-- page 지시자를 확인하고 있습니다. (상단) -->
	<h1>Hello World!</h1>
	<p>The time on the server is ${serverTime }</p>
	
	<!-- 스크립트릿 표현을 확인하고 있습니다. -->
	<p>스크립트릿 표현으로 출력하기</p>
	<p>The time on the server is <%=serverTime %></p>
	
	
</body>
</html>