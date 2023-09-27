<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>recipe</title>
<style>
	table{
		border : 2px solid black;
		border-collapse: collapse;
		margin: 10px auto;	
		padding: 10px;
	}
	th{
		background-color: #eee;
		border: 1px solid black;
		padding: 10px;
	}
	td{
		border: 1px solid black;
		padding: 10px;
	}
	textarea {
		margin: 10px 5px;
	}
	#boardView{
		margin: auto;
	}
	#boardTitle {
		border: 1px solid #eee;
		width: 800px;
		padding: 5px 15px;
		line-height: 2rem;
		margin: 5px;
		text-align: center;
	}
	#boardContent {
		border: 1px solid #eee;
		width: 800px;
		padding: 15px;
		line-height: 2rem;
		margin: 5px;
		text-align: center;
	}
	#boardUserid {
		border: 1px solid #eee;
		width: 800px;
		padding: 5px 15px;
		line-height: 2rem;
		margin: 5px;
		text-align: center;
	}
</style>
</head>
<body>
<h1><a href="${cpath }">recipe blog</a></h1>
<p align="right">
<c:if test="${empty login }">
	방문해주셔서 감사합니다.
</c:if>
<c:if test="${not empty login }">
	${login.userid } [${login.username }님]
</c:if>
</p>
<header>
	<nav>
		<ul>
			<c:if test="${empty login }">
				<li><a href="${cpath }/member/login">로그인</a></li>
				<li><a href="${cpath }/member/join">회원가입</a></li>
			</c:if>
			<c:if test="${not empty login }">
				<li><a href="${cpath }/member/logout">로그아웃</a></li>
				<li><a href="${cpath }/member/mypage">My Page</a></li>
			</c:if>
			<c:if test="${not empty login }">
				<li><a href="${cpath }/board/write">글작성</a></li>
				<!-- 드랍 메뉴 구현 할 수도? -->
			</c:if>
				<li><a href="${cpath }/board/list">레시피</a></li>
				<li><a href="${cpath }/review/list">댓글(구현 후 삭제)</a></li>
		</ul>
	</nav>
</header>