<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/nav.jsp"></c:import>


	<div class="container">

		<form action="./noticeList" id="frm">
			<input type="hidden" id="curPage" value="1" name="curPage"> 
			<select	id="kind" name="kind">
				<option id="kc" value="kc" selected="selected">CONTENTS</option>
				<option id="kt" value="kt">TITLE</option>
				<option id="kw" value="kw">WRITER</option>
			</select> <input type="text" id="search" name="search" value="${pager.search}">
			<button class="btn btn-basic">검색</button>
		</form>


		<table class="table table-hover">
			<tr>
				<td>Num</td>
				<td>Title</td>
				<td>Writer</td>
				<td>Date</td>
				<td>Hit</td>
			</tr>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="noticeSelect?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>

			</c:forEach>

		</table>


 <div>
	<ul class="pagination">
		<c:if test="${pager.curBlock gt 1}">
			<li><span id="${pager.startNum-1}" class="list">이전</span></li>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<li><span id="${i}" class="list">${i}</span></li>
		</c:forEach>
		<c:if test="${pager.curBlock lt pager.totalBlock}">
			<li><span id="${pager.lastNum+1}" class="list">다음</span></li>
		</c:if>
	</ul>
</div>
	</div>


<script type="text/javascript">
		var kind = '${pager.kind}'
		if (kind == '') {
			kind = "kt"
		}
		$("#" + kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	</script>



</body>
</html>