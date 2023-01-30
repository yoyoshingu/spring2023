<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./layout/header.jsp" %>


<%-- 초기버젼
<div class="container mt-3">
  <h2>Basic Card</h2>
  <div class="card">
    <div class="card-body">

		<h4 class="card-title">포스트제목</h4>
		<a href = "#" class="btn btn-secondary"> 상세내용보기 </a>
	</div>
  </div>
</div>
--%>

<%-- post 관리이후 버젼 p 148 --%>
<%-- 
<div class="container mt-3">
	<c:if test="${!empty postList }">
		<h2>PostCard포스트게시물</h2>
		<div class="card">
			<c:forEach var="post" items="${postList}">
				<div class="card-body">

					<h4 class="card-title">포스트제목${post.title }</h4>
					<a href="#" class="btn btn-secondary"> 상세내용보기 </a>
				</div>
			</c:forEach>
		</div>

	</c:if>
</div>
--%>

<%--			postList의 pagination을 위해 다음으로 바꿈 p152--%>
<div class="container mt-3">
	<c:if test="${!empty postList }">
		<h2>PostCard포스트게시물</h2>
		<div class="card">
			<c:forEach var="post" items="${postList.content}">
				<div class="card-body">

					<h4 class="card-title">포스트제목${post.title }</h4>
					<%-- <a href="#" class="btn btn-secondary"> 상세내용보기 </a> --%>
					<a href="/post/${post.id}" class="btn btn-secondary"> 상세내용보기 </a>
					
				</div>
			</c:forEach>
		</div>
		<br>
		<ul class="pagination justify-content-between">
		<%-- 
			<li class="page-item"><a class="page-link href="?page=${postList.number - 1}">이전페이지</a></li>
			<li class="page-item"><a class="page-link href="?page=${postList.number + 1}">다음페이지</a></li>		
			다음으로 수정됨 --%>
			<li class="page-item <c:if test="${postList.first}">diabled</c:if>">
				<a class="page-link href="?page=${postList.number - 1}">이전페이지</a></li>
			<li class="page-item <c:if test="${postList.last}">diabled</c:if>">">
				<a class="page-link href="?page=${postList.number + 1}">다음페이지</a></li>		
		</ul>
	</c:if>
</div>

<%@ include file="./layout/footer.jsp" %>