<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<section class="content-header">
	<c:set  value="등록" var="name" />
	<c:if test="${status eq 'u' }">
		<c:set value="수정" var="name"/>
	</c:if>
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>공지사항 ${name }</h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
					<li class="breadcrumb-item active">공지사항 ${name }</li>
				</ol>
			</div>
		</div>
	</div>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="card card-primary">
				<form:form action="/notice/insert.do" method="post" id="noticeForm" modelAttribute="noticeVO">
					<c:if test="${status eq 'u' }">
						<input type="hidden" name="boNo" value="${notice.boNo }"/>
					</c:if>
					<div class="card-header">
						<h3 class="card-title">공지사항 ${name }</h3>
						<div class="card-tools"></div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="inputName">제목을 입력해주세요</label> <input type="text"
								id="boTitle" name="boTitle" value="${notice.boTitle }" class="form-control" placeholder="제목을 입력해주세요">
						</div>
						<div class="form-group">
							<label for="inputDescription">내용을 입력해주세요</label>
							<textarea id="boContent" name="boContent" class="form-control" rows="14">${notice.boContent }</textarea>
						</div>
						<div class="form-group">
	
							<div class="custom-file">
								<label for="inputDescription">파일 선택</label> <input type="file"
									class="custom-file-input" id="customFile"> <label
									class="custom-file-label" for="customFile">파일을 선택해주세요</label>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<a href="/notice/list.do">
									<input type="button" value="목록" class="btn btn-success float-right"> 
								</a>
								<input type="button" value=${name } id="formBtn" class="btn btn-primary float-right">
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>

<script>
$(function() {
	var formBtn = $("#formBtn");
	
	formBtn.on("click", function() {
		if($("#boTitle").val() == null || $("#boTitle").val() == "") {
			alert("제목을 입력해주세요.");
			$("#boTitle").focus();
			return false;
		}
		
		if($(this).val() == '수정'){
			$("#noticeForm").attr("action", "/notice/update.do")
		}
		
		$("#noticeForm").submit();
	});
	
});
</script>



