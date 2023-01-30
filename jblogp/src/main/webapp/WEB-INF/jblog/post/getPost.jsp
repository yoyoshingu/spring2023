<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="../layout/header.jsp" %>
    


<br><br>
<div class="container border">
	 <br>
      <div>
      <h3>${post.title}</h3>
    </div>
    
    	 <br>
      <div>
      <h3>${post.content}</h3>
    </div>
  
    <div >
		포스트번호: <span id="id"><i>${post.id} </i></span><br>
		작성자: <span ><i>${post.user.username} </i></span><br>
    </div>
	<hr>
	
    <button class="btn btn-primary" onclick()="history.back()">돌아가기</button>
    
    <%-- 수정과 삭제는 작성자만 가능하도록 수정 p 168--%>
    <c:if test="${post.user.username == principal.username }">
    <a href="/post/updatePost/${post.id}" class="btn btn-warning">수정하기</a>
	<button id="btn-delete" class=btn btn-danger>삭제하기</button>
	</c:if>
	<br><br>
</div>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp" %>
