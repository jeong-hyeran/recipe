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
	table {
		border: 1px solid black;
		border-collapse: collapse;
	}
	tr, th {
		border: 1px solid grey;
		padding: 10px 20px;
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
			<c:set var="loginLink" value="${empty login ? 'login' : 'logout' }" />
			<c:set var="isLogin" value="${empty login ? '로그인' : '로그아웃' }" />
			<c:set var="joinLink" value="${empty login ? 'join' : 'mypage' }" />
			<c:set var="isJoin" value="${empty login ? '회원가입' : 'My Page' }" />
			
					
			<li><a href="${cpath }/member/${loginLink }">${isLogin }</a></li>
			<li><a href="${cpath }/member/${joinLink }">${isJoin }</a></li>
				
			<c:if test="${not empty login }">
				<li><a href="${cpath }/board/write">글작성(글목록으로 이동)</a></li>
				<!-- 드랍 메뉴 구현 할 수도? -->
			</c:if>
				<li><a href="${cpath }/board/list">레시피</a></li>
				<li><a href="${cpath }/review/list">댓글(구현 후 삭제)</a></li>
		</ul>
	</nav>
</header>