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

	<%-- 댓글목록추가 p 181--%>
	<c:if test="${!empty post.replyList }">
		<div class="container mt-3">
			<table class="table">
				<thead>
					<tr>
						<th width="80%">내용</th>
						<th width="10%">작성자</th>
						<%-- 댓글 작성자만 삭제가 나타나도록 수정 p185 --%>
						<c:if
							test="${reply.user.username != null && reply.user.username == principal.username }">
							<th width="10%">삭제</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reply" items="${post.replyList }">
						<tr align="right">
						<tr>
							<td>${reply.content }</td>
							<td>${reply.user.username }</td>
							<%-- 댓글 작성자만 삭제가 나타나도록 수정 p185 --%>
							<c:if
								test="${reply.user.username != null && reply.user.username == principal.username }">

								<td><button
										onclick="replyObject.deleteReply(${post.id}, ${reply.id })">삭제</button></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>


	<%-- 댓글가능하도록 p 171--%>
	<div class="container mt-3">
 <input type="hidden" id="postId" value="${post.id }">       
  <table class="table">
    <thead>
      <tr>
        <th><h4>댓글목록</h4></th>
      </tr>
    </thead>
    <tbody>
    	<tr align="right">
      <tr>
        <td><textarea id="reply-content" rows=1 class="form-control"> </textarea>
        <button id="btn-save-reply" class="btn btn-secondary">댓글등록</button>
        </td>
      </tr>
  
    </tbody>
  </table>
</div>
	
</div>

<script src="/js/post.js"></script>
<script src="/js/reply.js"></script>

<%@ include file="../layout/footer.jsp" %>
