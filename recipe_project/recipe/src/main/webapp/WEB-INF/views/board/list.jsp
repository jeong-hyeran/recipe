<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="boardList">
<h3>글목록</h3>

<div class="boardSearch">
	<form method="POST" action="${cpath}/board/search">
	    <p>
	        <select name="searchOption">
	            <option value="keyword">포함 할</option>
	            <option value="excludeKeyword">제외 할</option>
	        </select>
	        <input type="search" name="keyword" placeholder="재료를 입력하세요" autofocus required>
	        <input type="submit" value="검색">
	    </p>
	</form>
</div>

<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>재료</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	
	<tbody>
			<tr>
				<c:if test="${empty list }">
					<td colspan="6" style="text-align: center;">
						작성 된 글이 없습니다.
					</td>
				</c:if>
			</tr>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath }/board/view/${dto.idx}">${dto.title }</a>
				</td>
				<td>${dto.ingr }</td>
				<td>${dto.member_userid }</td>
				<td>${dto.wdate }</td>
				<td>👁️‍🗨️${dto.viewCount }</td>
				<td>❤️${dto.likeCount }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ul>
	<li><a href="${cpath }/board/write"><button>글작성</button></a></li>
</ul>
</div>
</body>
</html>