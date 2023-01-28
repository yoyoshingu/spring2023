<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="../layout/header.jsp" %>
    


<div class="container mt-3">
  <form>
      <div class="mb-3 mt-3">
      <label for="title">Title제목::</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title">
    </div>
  
    <div class="mb-3 mt-3">
      <label for="content">Content내용:</label>
      <textarea  class="form-control" rows=5 id="content" ></textarea>
    </div>

    <button id="btn-insert" type="submit" class="btn btn-primary">포스트등록</button>
  </form>
</div>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp" %>
