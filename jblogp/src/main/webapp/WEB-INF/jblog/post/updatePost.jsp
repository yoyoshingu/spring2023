<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="../layout/header.jsp" %>
    


<div class="container mt-3">
  <form>
  	<input type="hidden" id="id" value="${post.id }">
      <div class="mb-3 mt-3">
      <label for="title">Title제목::</label>
      <input type="text" class="form-control" id="title" value="${post.title }">
    </div>
  
    <div class="mb-3 mt-3">
      <label for="content">Content내용:</label>
      <textarea  class="form-control" rows=5 id="content" >${post.content} </textarea>
    </div>

    <button class="btn btn-primary" onclick()="history.back()">돌아가기</button>
    <button id="btn-update" class="btn btn-warning">포스트수정</button>
  </form>
</div>



<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp" %>
