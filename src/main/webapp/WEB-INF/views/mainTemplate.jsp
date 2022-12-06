<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DDIT NOTICE</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/dist/css/adminlte.min.css">
<script src="${pageContext.request.contextPath }/resources/plugins/jquery/jquery.min.js""></script>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- header(nav, aside)가 있던 자리에 tile로 갔다는 흔적을 남겨줌! -->
		<!-- tiles-config.xml에 설정했던 put-attribute의 name과 일치해야 매핑됨. -->
		<tiles:insertAttribute name="header"/>
 		<div class="content-wrapper">
			<!-- content(section)가 있던 자리에 tile로 갔다는 흔적을 남겨줌! -->
			<tiles:insertAttribute name="content"/>
  		</div>
		<!-- footer가 있던 자리에 tile로 갔다는 흔적을 남겨줌! -->
  		<tiles:insertAttribute name="footer"/>
	</div>

<script src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/dist/js/adminlte.min.js"></script>
<%-- <script src="${pageContext.request.contextPath }/resources/dist/js/demo.js"></script> --%>
</body>
</html>
