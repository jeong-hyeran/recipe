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
	body{
		width: 1200px;
		margin: auto;
	}
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
	#boardIngr {
		box-sizing:border-box;
		border: 1px solid #eee;
		width: 800px;
		padding: 5px;
		margin: 5px;
		text-align: center;
	}

	#boardTitle{
		box-sizing:border-box;
		border: 1px solid #eee;
		width: 800px;
		padding: 10px 20px;
		height:80px;
		margin: 5px;
		text-align: center;
		display: flex;
	}
	
	#boardTitle > div:last-child {
		padding-left: 5px;
		font-weight: bold;
		font-size: 1.5rem;
		
	}
 	#boardTitle > div{ 
 		margin: auto; 
		padding: 0; 
 	} 
 	#boardTitle > div:first-child{
 		margin-right:2px; 
 	} 
 	#boardTitle > div:last-child{
 		margin-left:2px; 
 	} 
	#boardTitle > div > a {
		display: inline-block;
		height: 10px;
		font-size: 0.5rem;
	}

	#boardTitle > div > a > img{
		border-radius:50%;
		width: 40px;
	}

	#boardContent {
		box-sizing:border-box;
		border: 1px solid #eee;
		width: 800px;
		padding: 15px;
		line-height: 2rem;
		margin: 5px;
		text-align: center;
	}
	#boardContent > div > img{
		width: 400px;
	}
	ul{
		list-style: none;
		display: flex;
		padding: 5px 20px;
		justify-content: space-around;
		margin: 5px;
	}
	li{
		margin: 5px;
		padding: 5px;
	}
	a{
		all : unset;
		cursor: pointer;
	}
	a:hover {
		text-decoration: underline;
	}
	#restore{
		font-size: 0.7rem;
		font-weight: bold;
	}
	.boardSearch{
		margin:5px 35px;
	}
	
	.keyword{
		margin:5px 35px;
		display: flex;
	}
	.include, .exclude{
		margin: 10px;
		padding: 5px;
		
	}
	.boardList{
		box-sizing: border-box;
		margin: auto;
		padding: 10px 100px; 
	}
	.boardList > table{
		width: 950px;
	}	
	.boardList > table > tbody > tr >  td:first-child{
		text-align: center;
	}
</style>
</head>
<body>
<h1><a href="${cpath }">Recipe Blog</a></h1>
<p align="right">
<c:if test="${empty login }">
	로그인이 필요합니다.
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
<hr>