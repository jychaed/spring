<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<section class="content-header">
   <c:set value="등록" var="name"/>
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
                  <label for="inputName">제목을 입력해주세요</label>
                  <input type="text" name="boTitle" value="${notice.boTitle }" id="boTitle" class="form-control" placeholder="제목을 입력해주세요">
               </div>
               <div class="form-group">
                  <label for="inputDescription">내용을 입력해주세요</label>
                  <textarea id="inputDescription" name="boContent" class="form-control" rows="14">${notice.boContent }</textarea>
               </div>
               <div class="form-group">

                  <div class="custom-file">
                     <label for="inputDescription">파일 선택</label>
                     <input type="file" class="custom-file-input" id="customFile">
                     <label class="custom-file-label" for="customFile">파일을 선택해주세요</label>
                  </div>
               </div>
               <div class="row">
                  <div class="col-12">
                     <a href="/notice/list.do">
                        <input type="button" value="목록" class="btn btn-success float-right">
                     </a>
                     <input type="button" value="${name }" id="formBtn" class="btn btn-primary float-right">
                  </div>
               </div>
            </div>
            <div class="card-footer bg-white">
              <ul class="mailbox-attachments d-flex align-items-stretch clearfix">
               <li>
                 <span class="mailbox-attachment-icon"><i class="far fa-file-pdf"></i></span>

                 <div class="mailbox-attachment-info">
                  <a href="#" class="mailbox-attachment-name"><i class="fas fa-paperclip"></i> Sep2014-report.pdf</a>
                     <span class="mailbox-attachment-size clearfix mt-1">
                       <span>1,245 KB</span>
                       <a href="#" class="btn btn-default btn-sm float-right"><i class="fas fa-times"></i></a>
                     </span>
                 </div>
               </li>
               <li>
                 <span class="mailbox-attachment-icon"><i class="far fa-file-word"></i></span>

                 <div class="mailbox-attachment-info">
                  <a href="#" class="mailbox-attachment-name"><i class="fas fa-paperclip"></i> App Description.docx</a>
                     <span class="mailbox-attachment-size clearfix mt-1">
                       <span>1,245 KB</span>
                       <a href="#" class="btn btn-default btn-sm float-right"><i class="fas fa-times"></i></a>
                     </span>
                 </div>
               </li>
               <li>
                 <span class="mailbox-attachment-icon has-img"><img src="${pageContext.request.contextPath}/resources/dist/img/photo1.png" alt="Attachment"></span>

                 <div class="mailbox-attachment-info">
                  <a href="#" class="mailbox-attachment-name"><i class="fas fa-camera"></i> photo1.png</a>
                     <span class="mailbox-attachment-size clearfix mt-1">
                       <span>2.67 MB</span>
                       <a href="#" class="btn btn-default btn-sm float-right"><i class="fas fa-times"></i></a>
                     </span>
                 </div>
               </li>
               <li>
                 <span class="mailbox-attachment-icon has-img"><img src="${pageContext.request.contextPath}/resources/dist/img/photo2.png" alt="Attachment"></span>

                 <div class="mailbox-attachment-info">
                  <a href="#" class="mailbox-attachment-name"><i class="fas fa-camera"></i> photo2.png</a>
                     <span class="mailbox-attachment-size clearfix mt-1">
                       <span>1.9 MB</span>
                       <a href="#" class="btn btn-default btn-sm float-right"><i class="fas fa-times"></i></a>
                     </span>
                 </div>
               </li>
              </ul>
            </div>
         </form:form>
         </div>
      </div>
   </div>
</section>

<script>
$(function(){
   CKEDITOR.replace('boContent', {
      uiColor: '#ffffff', 
      defaultLanguage: 'ko',
      language: 'ko',
      extraPlugins: 'editorplaceholder',
      editorplaceholder: 'Start typing here...!',
      width: '100%',
      height: 600,
      
      
      //Default Image Plugins
      //# 기본 이미지 플러그인을 사용 시, 내 컴퓨터에서 이미지를 사용하기 위해선 아래 셋팅이 필요하다.
      //- filebrowserUploadUrl: '경로'
      //# 기본 이미지 플러그인을 사용 시, 내 컴퓨터에서 이미지를 Drag&Drop 기능을 사용하여 이미지를 포함시키기 위해서는 아래 셋팅이 필요하다
      // - uploadUrl: '경로'
      // - extraPlugins: 'uploadimage'
      // uploadUrl : '경로'
      //filebrowserUploadUrl: '경로'
      
      //Enhanced Image Plugins
      //# 향상된 이미지 플러그인을 사용 시, 내 컴퓨터에서 이미지를 사용하기 위해서는 아래 셋팅이 필요하다.
      //- filebrowserUploadUrl: '경로'
      //# 향상된 이미지 플러그인을 사용 시, 내 컴퓨터에서 이미지를 Drag&Drop 기능을 사용하여 이미지를 포함시키기 위해서는 아래 셋팅이 필요하다
      // uploadUrl : '경로'
      //filebrowserUploadUrl: '경로'
      
      //Easy Image Plugins
      //Easy Image는 클라우드서비스와 연동하여 내가 올린 이미지 자료들을 따로 관리할 수 있도록 해준다.
      //클라우드 서비스 대시보드를 통해 내 프로젝트의 토큰과 업로드 URL을 제공하여 해당 endpoing로 이미지를 관리할 수 있도록 하는 장점이 있다.
      //https://dashboard.ckeditor.com/
      //extraPlugins: 'easyimage',
      //removePlugins: 'image',
      //cloudServices_tokenUrl: 'https://91531.cke-cs.com/token/dev/[내 프로젝트(대시보드) 토큰]?limit=10',
      //cloudServices_uploadUrl: 'https://91531.cke-cs.com/easyimage/upload/'
      
      //CKEditor 적용된 내용을 가져오는 방법
      //CKEDITOR.instances.boContent.getDate();
      
      //easyimage는 ckeditor의 cloudservice를 이용해야 함
      extraPlugins: 'easyimage',
      removePlugins: 'image',
      footnotesPrepix: 'a',
      //easyimage사용하려면 filebrowserUploadUrl은 주석처리-다른 plugin이 필요함
//       filebrowserUploadUrl: '${pageContext.request.contextPath}/imageUpload.do',
      cloudServices_tokenUrl: 'https://91531.cke-cs.com/token/dev/01e07e2d21225e84f5a18ab4e1fa9623b71709a77ed4eb5cc1f5eb36d3aa?limit=10',
      cloudServices_uploadUrl: 'https://91531.cke-cs.com/easyimage/upload/'
   });
   
   
   var formBtn = $("#formBtn");
   
   formBtn.on("click", function(){
      if($("#boTitle").val() == null || $("#boTitle").val() == ""){
         alert("제목을 입력해주세요.");
         $("#boTitle").focus();
         return false;
      }
      
      //this: formBtn
      if($(this).val() == "수정"){
         $("#noticeForm").attr("action", "/notice/update.do");
      }
      
      $("#noticeForm").submit();
   })
})
</script>
