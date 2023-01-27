<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="../layout/header.jsp" %>
    


<div class="container mt-3">
  <form>
      <div class="mb-3 mt-3">
      <label for="uname">Username사용자이름:</label>
      <input type="text" class="form-control" id="username" placeholder="사용자이름" name="username">
    </div>
  

    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button id="btn-login" type="submit" class="btn btn-primary">Submit로그인</button>
  </form>
</div>

<script src="/js/login.js"></script>

<%@ include file="../layout/footer.jsp" %>
