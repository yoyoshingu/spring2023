<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">용희시작화면</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
    <c:if test="${sessionScope.principal == null }">
    
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/auth/login">로그인 스프링연습</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/insertUser">회원가입 스프링연습</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
     </c:if> 
      
       <c:if test="${sessionScope.principal != null }">
    
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="/auth/login">회원상세 스프링연습</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/auth/logout">로그아웃 스프링연습</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
     </c:if>  
      
      
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>
