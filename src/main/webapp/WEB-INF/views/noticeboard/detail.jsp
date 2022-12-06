<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="content-header">
   <div class="container-fluid">
      <div class="row mb-2">
         <div class="col-sm-6">
            <h1>공지사항 상세보기</h1>
         </div>
         <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
               <li class="breadcrumb-item"><a href="#">DDIT HOME</a></li>
               <li class="breadcrumb-item active">공지사항 상세보기</li>
            </ol>
         </div>
      </div>
   </div>
</section>

<section class="content">
   <div class="container-fluid">
      <div class="row">
         <div class="col-md-12">
            <div class="card card-primary">
               <div class="card-header">
                  <h3 class="card-title">${noticeVO.boTitle }</h3>
                  <div class="card-tools">${noticeVO.boWriter } ${noticeVO.boDate } ${noticeVO.boHit }</div>
               </div>
               <form id="quickForm" novalidate="novalidate">
                  <div class="card-body">${noticeVO.boContent }</div>

                  <div class="card-footer">
                     <button type="button" class="btn btn-primary" id="listBtn">목록</button>
                     <button type="button" class="btn btn-info" id="updateBtn">수정</button>
                     <button type="button" class="btn btn-danger" id="delBtn">삭제</button>
                  </div>
               </form>
            </div>
         </div>
         <form action="/notice/update.do" method="get" id="nFrm">
         	<input type="hidden" name="boNo" value="${noticeVO.boNo }">
         </form>
         <div class="col-md-12"></div>
      </div>
   </div>
</section>

<script>
$(function() {
	var nFrm = $("#nFrm");
	var listBtn = $("#listBtn");
	var updateBtn = $("#updateBtn");
	var delBtn = $("#delBtn");
	
	listBtn.on("click", function() {
		location.href = "/notice/list.do";
	});
	
	updateBtn.on("click", function() {
		nFrm.submit();
	});
	
	delBtn.on("click", function() {
		if(confirm("정말로 삭제?")){
			nFrm.attr("method", "post");
			nFrm.attr("action", "/notice/delete.do");
			nFrm.submit();
		}else{
			nFrm.reset();
		}
	});
	
	
	
});


</script>



