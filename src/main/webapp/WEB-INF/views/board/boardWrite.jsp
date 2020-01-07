<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	
	

	<div class="container">
	<form:form modelAttribute="noticeVO" id="frm" enctype="multipart/form-data">
			<div class="form-group">
		      <label for="writer">Writer:</label>
		      <form:input  class="form-control" path="writer"/>
		      <form:errors path="writer"></form:errors>
		    </div>
		    
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <form:input placeholder="Enter title" class="form-control" path="title"/>
		      <form:errors path="title" cssClass="error"></form:errors>
		    </div>
			
			<div class="form-group">
		      <label for="contents">Contents:</label>
			<form:textarea cssClass="form-control" path="contents" id="contents"/>
			<form:errors cssClass="contents" path="contents"></form:errors>
			</div>
			
			 <div class="row" >
		    	<input type="button"  class="btn btn-info col-sm-3" id="add" value="ADD FILE">
		    	<div id="files" class="col-sm-12"></div>
		    </div>
		    <div class="row"></div>
		     <div class="row" style="margin-top: 50px;">
		    <input type="button" id="write" class="btn btn-danger col-sm-3" value="Write">
		   	</div> 
		</form:form>
</div>
	<script type="text/javascript" src="../js/summernote.js" ></script>
	<script type="text/javascript" src="../js/fileCount.js"></script>

	
	
	

</body>
</html>